/**
 * Created by jayani on 5/14/2017.
 */
package net.mzouabi.ng2.server.dto.tabu;
import java.util.HashMap;

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
 * unpacks its chromosome, and creates Class objects from the genetic
 * information. Class objects are lightweight; they're just containers for
 * information with getters and setters, but it's more convenient to work with
 * them than with the chromosome directly.
 * <p>
 * The calcClashes method is used by GeneticAlgorithm.calcFitness, and requires
 * that createClasses has been run first. calcClashes looks at the Class objects
 * created by createClasses, and figures out how many hard constraints have been
 * violated.
 */

public class Timetable {
    private final HashMap<Integer, Room> rooms;
    private final HashMap<Integer, Professor> professors;
    private final HashMap<Integer, Course> courses;
    private final HashMap<Integer, Group> groups;
    private final HashMap<Integer, Timeslot> timeslots;
    private Class classes[];

    private int numClasses = 0;

    /**
     * Initialize new Timetable
     */
    public Timetable() {
        this.rooms = new HashMap<Integer, Room>();
        this.professors = new HashMap<Integer, Professor>();
        this.courses = new HashMap<Integer, Course>();
        this.groups = new HashMap<Integer, Group>();
        this.timeslots = new HashMap<Integer, Timeslot>();
    }


    public HashMap<Integer, Group> getGroups() {
        return this.groups;
    }

    public HashMap<Integer, Timeslot> getTimeslots() {
        return this.timeslots;
    }

    public HashMap<Integer, Course> getCourses() {
        return this.courses;
    }

    public HashMap<Integer, Professor> getProfessors() {
        return this.professors;
    }

    public HashMap<Integer, Room> getRooms() { return this.rooms; }
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
     * Add new course
     *
     * @param courseId
     * @param courseCode
     * @param course
     * @param professorIds
     */
    public void addCourse(int courseId, String courseCode, String course, int professorIds[]) {
        this.courses.put(courseId, new Course(courseId, courseCode, course, professorIds));
    }

    /**
     * Add new group
     *
     * @param groupId
     * @param groupSize
     * @param courseIds
     */
    public void addGroup(int groupId, int groupSize, int courseIds[]) {
        this.groups.put(groupId, new Group(groupId, groupSize, courseIds));
        this.numClasses = 0;
    }

    /**
     * Add new timeslot
     *
     * @param timeslotId
     * @param timeslot
     */
    public void addTimeslot(int timeslotId, String timeslot) {
        this.timeslots.put(timeslotId, new Timeslot(timeslotId, timeslot));
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
     * Get course from courseId
     *
     * @param courseId
     * @return course
     */
    public Course getCourse(int courseId) {
        return (Course) this.courses.get(courseId);
    }

    /**
     * Get courseIds of student group
     *
     * @param groupId
     * @return courseId array
     */
    public int[] getGroupCourses(int groupId) {
        Group group = (Group) this.groups.get(groupId);
        return group.getCourseIds();
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
    public Timeslot getTimeslot(int timeslotId) {
        return (Timeslot) this.timeslots.get(timeslotId);
    }

    /**
     * Get random timeslotId
     *
     * @return timeslot
     */
    public Timeslot getRandomTimeslot() {
        Object[] timeslotArray = this.timeslots.values().toArray();
        Timeslot timeslot = (Timeslot) timeslotArray[(int) (timeslotArray.length * Math.random())];
        return timeslot;
    }

    /**
     * Get classes
     *
     * @return classes
     */
    public Class[] getClasses() {
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
            numClasses += group.getCourseIds().length;
        }
        this.numClasses = numClasses;
        return this.numClasses;
    }

}