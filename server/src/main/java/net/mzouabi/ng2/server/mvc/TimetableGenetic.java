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
            timetable.addRoom(room.getRoom_id(), room.getRoom_name(), room.getCapacity());
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
            ArrayList<CourseLecturerMap> courseLecturerMapArrayList = courseLecturerMapRepository.findByCourseId(course.getCourse_id());
            int[] lectureArray = new int[courseLecturerMapArrayList.size()];
            for(int i= 0 ; i<courseLecturerMapArrayList.size() ; i++){
                lectureArray[i] = courseLecturerMapArrayList.get(i).getLecturer_id();
            }

            ArrayList<GroupCourseMap> courseGroupMapArrayList = groupCourseMapRepository.findByCourseId(course.getCourse_id());
            int[] groupArray = new int[courseGroupMapArrayList.size()];
            for(int i= 0 ; i<courseGroupMapArrayList.size() ; i++){
                groupArray[i] = courseGroupMapArrayList.get(i).getGroupId();
            }
            timetable.addModule(course.getCourse_id(), course.getCourse_code(), course.getCourse_name(), lectureArray, groupArray);
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
                coursesArray[i] = groupCourseMapArrayList.get(i).getCourseId();
            }
            timetable.addGroup(grp.getGroupId(),grp.getGroup_size(),coursesArray);
        }
//        timetable = initializeTimetable(timetable);


        // Initialize GA
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.1, 0.9, 2, 5);

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
            mapper.writeValue(new File("F://FYP/output.txt"), jsonArray);
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
//    private static Timetable initializeTimetable(Timetable timetable) {
        // Create timetable
        //Timetable timetable = new Timetable();

        // Set up rooms
/*
        timetable.addRoom(1, "A1", 15);
        timetable.addRoom(2, "B1", 30);
        timetable.addRoom(4, "D1", 20);
        timetable.addRoom(5, "F1", 25);

        // Set up timeslots
        timetable.addTimeslot(1, "Mon 9:00 - 11:00");
        timetable.addTimeslot(2, "Mon 11:00 - 13:00");
        timetable.addTimeslot(3, "Mon 13:00 - 15:00");
        timetable.addTimeslot(4, "Tue 9:00 - 11:00");
        timetable.addTimeslot(5, "Tue 11:00 - 13:00");
        timetable.addTimeslot(6, "Tue 13:00 - 15:00");
        timetable.addTimeslot(7, "Wed 9:00 - 11:00");
        timetable.addTimeslot(8, "Wed 11:00 - 13:00");
        timetable.addTimeslot(9, "Wed 13:00 - 15:00");
        timetable.addTimeslot(10, "Thu 9:00 - 11:00");
        timetable.addTimeslot(11, "Thu 11:00 - 13:00");
        timetable.addTimeslot(12, "Thu 13:00 - 15:00");
        timetable.addTimeslot(13, "Fri 9:00 - 11:00");
        timetable.addTimeslot(14, "Fri 11:00 - 13:00");
        timetable.addTimeslot(15, "Fri 13:00 - 15:00");

        // Set up professors
        timetable.addProfessor(1, "Dr P Smith");
        timetable.addProfessor(2, "Mrs E Mitchell");
        timetable.addProfessor(3, "Dr R Williams");
        timetable.addProfessor(4, "Mr A Thompson");

        // Set up modules and define the professors that teach them
        timetable.addModule(1, "cs1", "Computer Science", new int[]{1, 2});
        timetable.addModule(2, "en1", "English", new int[]{1, 3});
        timetable.addModule(3, "ma1", "Maths", new int[]{1, 2});
        timetable.addModule(4, "ph1", "Physics", new int[]{3, 4});
        timetable.addModule(5, "hi1", "History", new int[]{4});
        timetable.addModule(6, "dr1", "Drama", new int[]{1, 4});*/

//         Set up student groups and the modules they take.
//        timetable.addGroup(1, 10, new int[]{1, 3, 4});
//        timetable.addGroup(2, 30, new int[]{2, 3, 5, 6});
//        timetable.addGroup(3, 18, new int[]{3, 4, 5});
//        timetable.addGroup(4, 25, new int[]{1, 4});
//        timetable.addGroup(5, 20, new int[]{2, 3, 5});
//        timetable.addGroup(6, 22, new int[]{1, 4, 5});
//        timetable.addGroup(7, 16, new int[]{1, 3});
//        timetable.addGroup(8, 18, new int[]{2, 6});
//        timetable.addGroup(9, 24, new int[]{1, 6});
//        timetable.addGroup(10, 25, new int[]{3, 4});
//        return timetable;
//    }

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
}
