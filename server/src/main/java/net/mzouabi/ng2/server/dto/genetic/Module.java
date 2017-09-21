/**
 * Created by jayani on 5/14/2017.
 */
package net.mzouabi.ng2.server.dto.genetic;

/**
 * Simple course module abstraction, which defines the Professors teaching the module.
 */
public class Module {
    private final int moduleId;
    private final String moduleCode;
    private final String module;
    private final int professorIds[];
    private final int groupIds[];
    private int duration;
    private int maxStudents;

    /**
     * Initialize new Module
     *
     * @param moduleId
     * @param moduleCode
     * @param module
     * @param professorIds
     */
    public Module(int moduleId, String moduleCode, String module, int professorIds[], int groupsIds[],int duration, int maxStudents) {
        this.moduleId = moduleId;
        this.moduleCode = moduleCode;
        this.module = module;
        this.professorIds = professorIds;
        this.groupIds = groupsIds;
        this.duration = duration;
        this.maxStudents = maxStudents;
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
     * Get module code
     *
     * @return moduleCode
     */
    public String getModuleCode() {
        return this.moduleCode;
    }

    /**
     * Get module name
     *
     * @return moduleName
     */
    public String getModuleName() {
        return this.module;
    }

    /**
     * Get random professor Id
     *
     * @return professorId
     */
    public int getRandomProfessorId() {
        int professorId = 0;
        if(professorIds.length != 0){
            professorId = professorIds[(int) (professorIds.length * Math.random())];
        }

        return professorId;
    }

    public int[] getGroupIds() {
        return groupIds;
    }

    public int[] getProfessorIds() {
        return professorIds;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }
}
