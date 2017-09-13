package net.mzouabi.ng2.server.repository;
/**
 * Created by Jayani on 08/15/17.
 */

import org.springframework.data.repository.Repository;
import net.mzouabi.ng2.server.model.GroupCourseMap;

import java.util.*;


public interface GroupCourseMapRepository extends Repository<GroupCourseMap, String> {
    ArrayList<GroupCourseMap> findByGroupId(int groupId);
    ArrayList<GroupCourseMap> findByCourseId(int courseId);
}