package net.mzouabi.ng2.server.repository;
/**
 * Created by Avindu on 15/07/17.
 */

import org.springframework.data.repository.Repository;
import net.mzouabi.ng2.server.model.CourseLecturerMap;

import java.util.*;


public interface CourseLecturerMapRepository extends Repository<CourseLecturerMap, String> {
    ArrayList<CourseLecturerMap> findByCourseid(int courseid);
}