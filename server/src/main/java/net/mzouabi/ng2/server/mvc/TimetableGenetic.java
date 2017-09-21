/**
 * Created by jayani on 5/14/2017.
 */
package net.mzouabi.ng2.server.mvc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import com.google.gson.Gson;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

import net.mzouabi.ng2.server.dto.genetic.*;
import net.mzouabi.ng2.server.repository.*;
import net.mzouabi.ng2.server.model.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/genetic")
public class TimetableGenetic {
    public String jsonArray;
    public ClassType[] classArray;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private TimeslotRepository timeslotRepository;

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseLecturerMapRepository courseLecturerMapRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupCourseMapRepository groupCourseMapRepository;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void mainmethod() {

        Timetable timetable = new Timetable(groupCourseMapRepository,courseLecturerMapRepository);

        Iterable<Classroom> classrooms = classroomRepository.findAll();
        List<Classroom> classroomList = new ArrayList<>();
        classrooms.forEach(classroomList::add);

        for(Classroom room : classroomList){
            timetable.addRoom(room.getRoomid(), room.getRoomname(), room.getCapacity());
        }

        Iterable<Timeslot> timeslots = timeslotRepository.findAll();
        List<Timeslot> timeslotList = new ArrayList<>();
        timeslots.forEach(timeslotList::add);

        for(Timeslot slot : timeslotList){
            timetable.addTimeslot(slot.getTimeslot_id(), slot.getTimeslot());
        }

        Iterable<Lecturer> lecturers = lecturerRepository.findAll();
        List<Lecturer> lecturerList = new ArrayList<>();
        lecturers.forEach(lecturerList::add);

        for(Lecturer lect : lecturerList){
            timetable.addProfessor(lect.getLecturer_id(), lect.getLecturer_name());
        }

        Iterable<Course> courses = courseRepository.findAll();
        List<Course> courseList = new ArrayList<>();
        courses.forEach(courseList::add);

        for(Course course : courseList){
            ArrayList<CourseLecturerMap> courseLecturerMapArrayList = courseLecturerMapRepository.findByCourseid(course.getCourseid());
            int[] lectureArray = new int[courseLecturerMapArrayList.size()];
            for(int i= 0 ; i<courseLecturerMapArrayList.size() ; i++){
                lectureArray[i] = courseLecturerMapArrayList.get(i).getLecturer_id();
            }

            ArrayList<GroupCourseMap> courseGroupMapArrayList = groupCourseMapRepository.findByCourseid(course.getCourseid());
            int[] groupArray = new int[courseGroupMapArrayList.size()];
            for(int i= 0 ; i<courseGroupMapArrayList.size() ; i++){
                groupArray[i] = courseGroupMapArrayList.get(i).getGroupId();
            }

            timetable.addModule(course.getCourseid(), course.getCourse_code(), course.getCourse_name(), lectureArray, groupArray , course.getDuration(), course.getMax_students());
        }

        Iterable<GroupModel> groups =groupRepository.findAll();
        List<GroupModel> groupList = new ArrayList<>();
        groups.forEach(groupList::add);
//        System.out.println("___________________________");
//        System.out.println(groupList.size());

        for(GroupModel grp : groupList){

            ArrayList<GroupCourseMap> groupCourseMapArrayList = groupCourseMapRepository.findByGroupId(grp.getGroupId());
            int[] coursesArray = new int[groupCourseMapArrayList.size()];
            for(int i= 0 ; i<groupCourseMapArrayList.size() ; i++){
                coursesArray[i] = groupCourseMapArrayList.get(i).getCourseid();
            }
            timetable.addGroup(grp.getGroupId(),grp.getGroup_size(),coursesArray);
        }
//        timetable = initializeTimetable(timetable);


        // Initialize GA
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.1, 0.95, 2, 5);

        // Initialize population
        Population population = ga.initPopulation(timetable);

        // Evaluate population
        ga.evalPopulation(population, timetable);

        // Keep track of current generation
        int generation = 1;

        // Start evolution loop
        while (ga.isTerminationConditionMet(generation, 100) == false
                && ga.isTerminationConditionMet(population) == false) {

            System.out.println("G" + generation + " Best fitness: " + population.getFittest(0).getFitness());
            // Apply crossover
            population = ga.crossoverPopulation(population);

            // Apply mutation
            population = ga.mutatePopulation(population, timetable);

            // Evaluate population
            ga.evalPopulation(population, timetable);

            // Increment the current generation
            generation++;
        }

        System.out.println();
        System.out.println("Solution found in " + generation + " generations");
        System.out.println("Final solution fitness: " + population.getFittest(0).getFitness());
        //System.out.println("Clashes: " + timetable.calcClashes());

        // Print fitness
        timetable.createClasses(population.getFittest(0));

        ClassType classes[] = timetable.getClasses();
        this.classArray = timetable.getClasses();
        Gson gson = new Gson();
        this.jsonArray = gson.toJson(classes);

        ObjectMapper mapper = new ObjectMapper();
        try {
            //Object to JSON in file
            mapper.writeValue(new File("D://FYP/output.txt"), jsonArray);
            // Initialize our objects
        }catch (JsonGenerationException e) {
            e.printStackTrace();
        }catch (JsonMappingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Creates a Timetable with all the necessary course information.
     * <p>
     * Normally you'd get this info from a database.
     *
     * @return
     */

    @RequestMapping(value = "/getTimetable", method = RequestMethod.GET)
    public ClassType[] getTimetable() {
        mainmethod();
        ClassType[] timetable= null;
////        timetable = this.jsonArray;
        try {
            timetable = this.classArray;
            return timetable;
        } catch (Exception e) {
            return timetable;
        }

    }

    @RequestMapping(value = "/findModuleById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String findModuleById(@RequestParam("courseid") String data) {
        System.out.println(data);
        int courseid = Integer.parseInt(data);
        String ModuleCode = null;
        ModuleCode = courseRepository.findByCourseid(courseid).course_code;
        return ModuleCode;
    }

    @RequestMapping(value = "/findRoomnameById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String findRoomnameById(@RequestParam("roomid") String data) {
        System.out.println(data);
        int roomid = Integer.parseInt(data);
        String RoomName = null;
        RoomName = classroomRepository.findByRoomid(roomid).roomname;
        return RoomName;
    }
}
