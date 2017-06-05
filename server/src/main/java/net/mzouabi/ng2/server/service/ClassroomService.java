package net.mzouabi.ng2.server.service;

import net.mzouabi.ng2.server.dto.ClassroomDTO;
import net.mzouabi.ng2.server.model.Classroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
/**
 * Created by Jayani on 05/30/17.
 */

public interface ClassroomService {

    List<Classroom> findClassrooms(Pageable pageable);

    ClassroomDTO getClassroomByID(String id);

<<<<<<< HEAD
    //void deleteClassroomByID(String id);

}
=======
    void updateClassRoom(ClassroomDTO classroomDTO);

    void addClassRoom(ClassroomDTO classroomDTO);

    void deleteClassRoomByID(String id);

}
>>>>>>> cb7af5c05017432d428b3dad165eca07f0bfd3db
