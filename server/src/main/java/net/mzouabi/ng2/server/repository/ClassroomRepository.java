package net.mzouabi.ng2.server.repository;
/**
 * Created by Jayani on 06/05/17.
 */

import org.springframework.data.repository.CrudRepository;
import net.mzouabi.ng2.server.model.Classroom;


public interface ClassroomRepository extends CrudRepository<Classroom, String> {
    Classroom findByRoomid(int roomid);
}