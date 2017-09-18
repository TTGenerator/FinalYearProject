package net.mzouabi.ng2.server.model;
/**
 * Created by Avindu on 15/07/17.
 */
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "courses")
public class Course {

    @Id
    @Column(name = "courseid")
    public int courseid;

    @Column(name = "course_code")
    public String course_code;

    @Column(name = "course_name")
    public String course_name;

    @Column(name = "duration")
    public int duration;

    @Column(name = "is_deleted")
    public int deleted;

    @Column(name = "max_students")
    public int max_students;

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getMax_students() {
        return max_students;
    }

    public void setMax_students(int max_students) {
        this.max_students = max_students;
    }
}