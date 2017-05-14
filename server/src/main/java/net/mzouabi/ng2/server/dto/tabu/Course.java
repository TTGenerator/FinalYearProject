/**
 * Created by jayani on 5/14/2017.
 */
package net.mzouabi.ng2.server.dto.tabu;
/**
 * Simple course course abstraction, which defines the Professors teaching the course.
 */
public class Course {
    private final int courseId;
    private final String courseCode;
    private final String course;
    private final int professorIds[];

    /**
     * Initialize new Course
     *
     * @param courseId
     * @param courseCode
     * @param course
     * @param professorIds
     */
    public Course(int courseId, String courseCode, String course, int professorIds[]) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.course = course;
        this.professorIds = professorIds;
    }

    /**
     * Get courseId
     *
     * @return courseId
     */
    public int getCourseId() {
        return this.courseId;
    }

    /**
     * Get course code
     *
     * @return courseCode
     */
    public String getCourseCode() {
        return this.courseCode;
    }

    /**
     * Get course name
     *
     * @return courseName
     */
    public String getCourseName() {
        return this.course;
    }

    /**
     * Get random professor Id
     *
     * @return professorId
     */
    public int getRandomProfessorId() {
        int professorId = professorIds[(int) (professorIds.length * Math.random())];
        return professorId;
    }
}
