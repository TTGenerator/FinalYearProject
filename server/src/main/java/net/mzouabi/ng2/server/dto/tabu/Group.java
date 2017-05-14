/**
 * Created by jayani on 5/14/2017.
 */
package net.mzouabi.ng2.server.dto.tabu;

/**
 * A simple "group-of-students" abstraction. Defines the courses that the group is enrolled in.
 */
public class Group {
    private final int groupId;
    private final int groupSize;
    private final int courseIds[];

    /**
     * Initialize Group
     *
     * @param groupId
     * @param groupSize
     * @param courseIds
     */
    public Group(int groupId, int groupSize, int courseIds[]) {
        this.groupId = groupId;
        this.groupSize = groupSize;
        this.courseIds = courseIds;
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
     * Get groupSize
     *
     * @return groupSize
     */
    public int getGroupSize() {
        return this.groupSize;
    }

    /**
     * Get array of group's courseIds
     *
     * @return courseIds
     */
    public int[] getCourseIds() {
        return this.courseIds;
    }
}
