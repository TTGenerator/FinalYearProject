/**
 * Created by jayani on 5/14/2017.
 */
package net.mzouabi.ng2.server.dto.genetic;

import java.util.Arrays;

/**
 * A simple class abstraction -- basically a container for class, group, module, professor, timeslot, and room IDs
 */
public class ClassType {
    private final int classId;
    private int[] groupId;
    private int moduleId;
    private int[] professorId;
    private int timeslotId;
    private int roomId;



    /**
     * Initialize new ClassType
     *
     * @param classId
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
    }

    public int getTimeslotId() {
        return timeslotId;
    }

    public void setTimeslotId(int timeslotId) {
        this.timeslotId = timeslotId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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
                ", roomId=" + roomId +
                '}';
    }
}

