package net.mzouabi.ng2.server.repository;
/**
 * Created by Avindu on 15/07/17.
 */

import org.springframework.data.repository.CrudRepository;
import net.mzouabi.ng2.server.model.Course;


public interface CourseRepository extends CrudRepository<Course, String> {
    Course findByCourseid(int courseid);
}