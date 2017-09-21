/**
 * Created by jayani on 5/14/2017.
 */
package net.mzouabi.ng2.server.dto.genetic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

import net.mzouabi.ng2.server.repository.*;
import net.mzouabi.ng2.server.model.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Timetable is the main evaluation class for the class scheduler GA.
 * <p>
 * A timetable represents a potential solution in human-readable form, unlike an
 * Individual or a chromosome. This timetable class, then, can read a chromosome
 * and develop a timetable from it, and ultimately can evaluate the timetable
 * for its fitness and number of scheduling clashes.
 * <p>
 * The most important methods in this class are createClasses and calcClashes.
 * <p>
 * The createClasses method accepts an Individual (really, a chromosome),
 * unpacks its chromosome, and creates ClassType objects from the genetic
 * information. ClassType objects are lightweight; they're just containers for
 * information with getters and setters, but it's more convenient to work with
 * them than with the chromosome directly.
 * <p>
 * The calcClashes method is used by GeneticAlgorithm.calcFitness, and requires
 * that createClasses has been run first. calcClashes looks at the ClassType objects
 * created by createClasses, and figures out how many hard constraints have been
 * violated.
 */

public class Timetable {
    private final HashMap<Integer, Room> rooms;
    private final HashMap<Integer, Professor> professors;
    private final HashMap<Integer, Module> modules;
    private final HashMap<Integer, Group> groups;
    private final HashMap<Integer, TimeslotDTO> timeslots;
    private ClassType classes[];


    private GroupCourseMapRepository groupCourseMapRepository;
    private CourseLecturerMapRepository courseLecturerMapRepository;

    private int numClasses = 0;

    /**
     * Initialize new Timetable
     */
    public Timetable(GroupCourseMapRepository groupCourseMapRepository, CourseLecturerMapRepository courseLecturerMapRepository) {
        this.rooms = new HashMap<Integer, Room>();
        this.professors = new HashMap<Integer, Professor>();
        this.modules = new HashMap<Integer, Module>();
        this.groups = new HashMap<Integer, Group>();
        this.timeslots = new HashMap<Integer, TimeslotDTO>();
        this.groupCourseMapRepository = groupCourseMapRepository;
        this.courseLecturerMapRepository = courseLecturerMapRepository;
    }

    /**
     * "Clone" a timetable. We use this before evaluating a timetable so we have
     * a unique container for each set of classes created by "createClasses".
     * Truthfully, that's not entirely necessary (no big deal if we wipe out and
     * reuse the .classes property here), but Chapter 6 discusses
     * multi-threading for fitness calculations, and in order to do that we need
     * separate objects so that one thread doesn't step on another thread's
     * toes. So this constructor isn't _entirely_ necessary for Chapter 5, but
     * you'll see it in action in Chapter 6.
     *
     * @param cloneable
     */
    public Timetable(Timetable cloneable) {
        this.rooms = cloneable.getRooms();
        this.professors = cloneable.getProfessors();
        this.modules = cloneable.getModules();
        this.groups = cloneable.getGroups();
        this.timeslots = cloneable.getTimeslots();
    }

    private HashMap<Integer, Group> getGroups() {
        return this.groups;
    }

    private HashMap<Integer, TimeslotDTO> getTimeslots() {
        return this.timeslots;
    }

    private HashMap<Integer, Module> getModules() {
        return this.modules;
    }

    private HashMap<Integer, Professor> getProfessors() {
        return this.professors;
    }

    /**
     * Add new room
     *
     * @param roomid
     * @param roomName
     * @param capacity
     */
    public void addRoom(int roomid, String roomName, int capacity) {
        this.rooms.put(roomid, new Room(roomid, roomName, capacity));
    }

    /**
     * Add new professor
     *
     * @param professorId
     * @param professorName
     */
    public void addProfessor(int professorId, String professorName) {
        this.professors.put(professorId, new Professor(professorId, professorName));
    }

    /**
     * Add new module
     *
     * @param moduleId
     * @param moduleCode
     * @param module
     * @param professorIds
     */
    public void addModule(int moduleId, String moduleCode, String module, int professorIds[], int groups[], int duration) {

        this.modules.put(moduleId, new Module(moduleId, moduleCode, module, professorIds, groups, duration));
    }

    /**
     * Add new group
     *
     * @param groupId
     * @param groupSize
     * @param moduleIds
     */
    public void addGroup(int groupId, int groupSize, int moduleIds[]) {
        this.groups.put(groupId, new Group(groupId, groupSize, moduleIds));
        this.numClasses = 0;
    }

    /**
     * Add new timeslot
     *
     * @param timeslotId
     * @param timeslot
     */
    public void addTimeslot(int timeslotId, String timeslot) {
        this.timeslots.put(timeslotId, new TimeslotDTO(timeslotId, timeslot));
    }

    public int [] getDurationArray(){
        int durationArray[] = new int[this.modules.size()+1];
        for (int i=1; i<=this.modules.size(); i++){
            durationArray[i] = this.modules.get(i).getDuration();
        }
        return durationArray;
    }

    /**
     * Create classes using individual's chromosome
     * <p>
     * One of the two important methods in this class; given a chromosome,
     * unpack it and turn it into an array of ClassType (with a capital C) objects.
     * These ClassType objects will later be evaluated by the calcClashes method,
     * which will loop through the Classes and calculate the number of
     * conflicting timeslots, rooms, professors, etc.
     * <p>
     * While this method is important, it's not really difficult or confusing.
     * Just loop through the chromosome and create ClassType objects and store them.
     *
     * @param individual
     */
    public void createClasses(Individual individual) {
        // Init classes
        int courseDurationArray[] = this.getDurationArray();
        int sum = IntStream.of(courseDurationArray).sum();
        ClassType classes[] = new ClassType[sum];
        // Get individual's chromosome
        int chromosome[] = individual.getChromosome();
        int classIndex = 0;
        int chromosomePos = 0;
        while (chromosomePos < chromosome.length){
            classes[classIndex] = new ClassType(classIndex);

            classes[classIndex].setTimeslotId(chromosome[chromosomePos]);
            chromosomePos++;

            classes[classIndex].setRoomid(chromosome[chromosomePos]);
            chromosomePos++;

            if(chromosome[chromosomePos]!=-1){
                classes[classIndex].setModuleId(chromosome[chromosomePos]);

                int groups[] = this.modules.get(chromosome[chromosomePos]).getGroupIds();
                classes[classIndex].setGroupId(groups);

                int lecturers[] = this.modules.get(chromosome[chromosomePos]).getProfessorIds();
                classes[classIndex].setProfessorId(lecturers);
            } else {
                classes[classIndex].setModuleId(-1);
            }

            chromosomePos++;
            classIndex++;
        }

        this.classes = classes;
    }

    /**
     * Get room from roomid
     *
     * @param roomid
     * @return room
     */
    public Room getRoom(int roomid) {
        if (!this.rooms.containsKey(roomid)) {
            System.out.println("Rooms doesn't contain key " + roomid);
        }
        return (Room) this.rooms.get(roomid);
    }

    public HashMap<Integer, Room> getRooms() {
        return this.rooms;
    }

    /**
     * Get random room
     *
     * @return room
     */
    public Room getRandomRoom() {
        Object[] roomsArray = this.rooms.values().toArray();
        Room room = (Room) roomsArray[(int) (roomsArray.length * Math.random())];
        return room;
    }

    /**
     * Get professor from professorId
     *
     * @param professorId
     * @return professor
     */
    public Professor getProfessor(int professorId) {
        return (Professor) this.professors.get(professorId);
    }

    /**
     * Get module from moduleId
     *
     * @param moduleId
     * @return module
     */
    public Module getModule(int moduleId) {
        return (Module) this.modules.get(moduleId);
    }

    /**
     * Get moduleIds of student group
     *
     * @param groupId
     * @return moduleId array
     */
    public int[] getGroupModules(int groupId) {
        Group group = (Group) this.groups.get(groupId);
        return group.getModuleIds();
    }

    /**
     * Get group from groupId
     *
     * @param groupId
     * @return group
     */
    public Group getGroup(int groupId) {
        return (Group) this.groups.get(groupId);
    }

    /**
     * Get all student groups
     *
     * @return array of groups
     */
    public Group[] getGroupsAsArray() {
        return (Group[]) this.groups.values().toArray(new Group[this.groups.size()]);
    }

    /**
     * Get timeslot by timeslotId
     *
     * @param timeslotId
     * @return timeslot
     */
    public TimeslotDTO getTimeslot(int timeslotId) {
        return (TimeslotDTO) this.timeslots.get(timeslotId);
    }

    /**
     * Get random timeslotId
     *
     * @return timeslot
     */
    public TimeslotDTO getRandomTimeslot() {
        Object[] timeslotArray = this.timeslots.values().toArray();
        double rand = timeslotArray.length * Math.random();
        TimeslotDTO timeslot = (TimeslotDTO) timeslotArray[(int) (rand)];
        return timeslot;
    }

    /**
     * Get classes
     *
     * @return classes
     */
    public ClassType[] getClasses() {
        return this.classes;
    }

    /**
     * Get number of classes that need scheduling
     *
     * @return numClasses
     */
    public int getNumClasses() {
        if (this.numClasses > 0) {
            return this.numClasses;
        }

        int numClasses = 0;
        Group groups[] = (Group[]) this.groups.values().toArray(new Group[this.groups.size()]);
        for (Group group : groups) {
            numClasses += group.getModuleIds().length;
        }
        this.numClasses = numClasses;

        return this.numClasses;
    }

    // Get number of timeslots in the DB
    public int getNumberofTimeslos(){
        return this.timeslots.size();
    }

    // Get number of classrooms in the DB
    public int getNumberOfClassrooms(){
        return this.rooms.size();
    }

    // Get number of modules in the DB
    public int getNumberOfModules(){
        return this.modules.size();
    }
    /**
     * Calculate the number of clashes between Classes generated by a
     * chromosome.
     * <p>
     * The most important method in this class; look at a candidate timetable
     * and figure out how many constraints are violated.
     * <p>
     * Running this method requires that createClasses has been run first (in
     * order to populate this.classes). The return value of this method is
     * simply the number of constraint violations (conflicting professors,
     * timeslots, or rooms), and that return value is used by the
     * GeneticAlgorithm.calcFitness method.
     * <p>
     * There's nothing too difficult here either -- loop through this.classes,
     * and check constraints against the rest of the this.classes.
     * <p>
     * The two inner `for` loops can be combined here as an optimization, but
     * kept separate for clarity. For small values of this.classes.length it
     * doesn't make a difference, but for larger values it certainly does.
     *
     * @return numClashes
     */
    public int calcClashes() {
        int clashes = 0;
        for (ClassType classA : this.classes) {
            // Check room capacity
            //System.out.println("Room is : " + getRoom(classA.getRoomid()).getRoomCapacity());
            if(classA.getModuleId()!=-1) {
                int roomCapacity = this.rooms.get(classA.getRoomid()).getRoomCapacity();
                int groupIds[] = classA.getGroupId();
                int groupSize = 0;
                for (int count = 0; count < groupIds.length; count++) {
                    groupSize += this.getGroup(groupIds[count]).getGroupSize();
                }

                if (roomCapacity < groupSize) {
                    clashes++;
                }
            }

            // Check if room is taken
            /*for (ClassType classB : this.classes) {
                if (classA.getRoomid() == classB.getRoomid() && classA.getTimeslotId() == classB.getTimeslotId()
                        && classA.getClassId() != classB.getClassId()) {
                    clashes++;
                    break;
                }
            }*/

            for (ClassType classB : this.classes) {
                if(classB.getModuleId() != -1) {
                    if (classA.getRoomid() == classB.getRoomid() && classA.getTimeslotId() == classB.getTimeslotId()
                            && classA.getClassId() != classB.getClassId()) {
                        clashes+=100;
                        //break;
                    }
                }
            }
/*
            // Check if professor is available
            for (ClassType classB : this.classes) {
                if (classA.getProfessorId() == classB.getProfessorId() && classA.getTimeslotId() == classB.getTimeslotId()
                        && classA.getClassId() != classB.getClassId()) {
                    clashes++;
                    break;
                }
            }*/

        }
        return clashes;
    }
}