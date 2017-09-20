/**
 * Created by jayani on 5/14/2017.
 */
package net.mzouabi.ng2.server.dto.genetic;
import java.util.*;
/**
 * A simple class abstraction -- basically a container for class, group, module, professor, timeslot, and room IDs
 */
public class ClassType {
    private final int classId;
    private int[] groupId;
    private int moduleId;
    private int[] professorId;
    private int timeslotId;
    private int roomid;



    /**
     * Initialize new ClassType
     *
     * @param classId
     * @param groupId
     * @param moduleId
     */
    public ClassType(int classId) {
        this.classId = classId;
    }

    public int getClassId() {
        return classId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
//        this.groupId = groupId;
    }

    /**
     * Add professor to class
     *
     * @param professorId
     */
//    public void addProfessor(int professorId) {
//        this.professorId = professorId;
//    }

    public void setTimeslotId(int timeslotId) {
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

    public int[] getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int[] professorId) {
        this.professorId = professorId;
    }

    public int[] getGroupId() {
        return groupId;
    }

    public void setGroupId(int[] groupId) {
        this.groupId = groupId;
    }
    public boolean isConsecutiveClasses(ClassType classA){
        return isSameDay(classA) && Math.abs(classA.getTimeslotId()-this.getTimeslotId())==1.0;

    }

    public boolean isSameDay(ClassType classA){
        return Math.ceil(classA.getTimeslotId()/8) == Math.ceil(this.getTimeslotId()/8);

    }
    @Override
    public String toString() {
        return "ClassType{" +
                "classId=" + classId +
                ", groupId=" + Arrays.toString(groupId) +
                ", moduleId=" + moduleId +
                ", professorId=" + Arrays.toString(professorId) +
                ", timeslotId=" + timeslotId +
                ", roomid=" + roomid +
                '}';
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

