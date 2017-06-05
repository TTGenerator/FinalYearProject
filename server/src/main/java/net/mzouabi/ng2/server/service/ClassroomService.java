package net.mzouabi.ng2.server.service;

import net.mzouabi.ng2.server.dto.ClassroomDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Jayani on 05/30/17.
 */

public interface ClassroomService {

    Page<ClassroomDTO> findClassrooms(Pageable pageable);

    ClassroomDTO getClassroomByID(String id);

    //void deleteClassroomByID(String id);

}
