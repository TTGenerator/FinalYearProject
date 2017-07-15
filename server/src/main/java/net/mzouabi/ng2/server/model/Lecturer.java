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
@Table(name = "lecturers")
public class Lecturer {

    @Id
    @Column(name = "lecturer_id")
    public int lecturer_id;

    @Column(name = "lecturer_name")
    public String lecturer_name;

    @Column(name = "lecturer_email")
    public String lecturer_email;

    @Column(name = "dept_id")
    public int dept_id;

    @Column(name = "has_preferences")
    public boolean has_preferences;

    public boolean isHas_preferences() {
        return has_preferences;
    }

    public void setHas_preferences(boolean has_preferences) {
        this.has_preferences = has_preferences;
    }

    public int getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(int lecturer_id) {
        this.lecturer_id = lecturer_id;
    }

    public String getLecturer_name() {
        return lecturer_name;
    }

    public void setLecturer_name(String lecturer_name) {
        this.lecturer_name = lecturer_name;
    }

    public String getLecturer_email() {
        return lecturer_email;
    }

    public void setLecturer_email(String lecturer_email) {
        this.lecturer_email = lecturer_email;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }
}