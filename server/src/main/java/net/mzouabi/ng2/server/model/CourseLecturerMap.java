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
@Table(name = "courselecturermap")
public class CourseLecturerMap {

    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "courseid")
    public int courseid;

    @Column(name = "lecturer_id")
    public int lecturer_id;

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(int lecturer_id) {
        this.lecturer_id = lecturer_id;
    }
}