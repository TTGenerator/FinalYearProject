/**
 * Created by jayani on 5/14/2017.
 */
package net.mzouabi.ng2.server.dto.genetic;
/**
 * A simple class abstraction -- basically a container for class, group, module, professor, timeslot, and room IDs
 */
public class ClassType {
    private final int classId;
    private final int groupId;
    private final int moduleId;
    private int professorId;
    private int timeslotId;
    private int roomid;

    /**
     * Initialize new ClassType
     *
     * @param classId
     * @param groupId
     * @param moduleId
     */
    public ClassType(int classId, int groupId, int moduleId) {
        this.classId = classId;
        this.moduleId = moduleId;
        this.groupId = groupId;
    }

    /**
     * Add professor to class
     *
     * @param professorId
     */
    public void addProfessor(int professorId) {
        this.professorId = professorId;
    }

    /**
     * Add timeslot to class
     *
     * @param timeslotId
     */
    public void addTimeslot(int timeslotId) {
        this.timeslotId = timeslotId;
    }

    /**
     * Add room to class
     *
     * @param roomid
     */
    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    /**
     * Get classId
     *
     * @return classId
     */
    public int getClassTypeId() {
        return this.classId;
    }

    /**
     * Get groupId
     *
     * @return groupId
     */
    public int getGroupId() {
        return this.groupId;
    }

    /**
     * Get moduleId
     *
     * @return moduleId
     */
    public int getModuleId() {
        return this.moduleId;
    }

    /**
     * Get professorId
     *
     * @return professorId
     */
    public int getProfessorId() {
        return this.professorId;
    }

    /**
     * Get timeslotId
     *
     * @return timeslotId
     */
    public int getTimeslotId() {
        return this.timeslotId;
    }

    /**
     * Get roomid
     *
     * @return roomid
     */
    public int getRoomid() {
        return this.roomid;
    }
}

