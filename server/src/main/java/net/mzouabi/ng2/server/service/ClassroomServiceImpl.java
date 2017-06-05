package net.mzouabi.ng2.server.service;

import net.mzouabi.ng2.server.dto.ClassroomDTO;
import net.mzouabi.ng2.server.mapper.ClassroomMapper;
import net.mzouabi.ng2.server.model.Classroom;
import net.mzouabi.ng2.server.repository.ClassroomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Created by Jayani on 05/30/17.
 */

@Service
@Transactional
public class ClassroomServiceImpl implements ClassroomService {

    final static Logger LOG = LoggerFactory.getLogger(ClassroomServiceImpl.class);

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    ClassroomMapper classroomMapper;

    @Override
    public List<Classroom> findClassrooms(Pageable pageable) {
        List<Classroom> classroomDTO = classroomRepository.findAll();
        return classroomDTO;
    }

    @Override
    public ClassroomDTO getClassroomByID(String id) {
        return classroomMapper.toDTO(classroomRepository.getOne(id));
    }
<<<<<<< HEAD
    /*
    @Override
    public void deleteClassroomByID(String id) {
        //articleDao.removeArticle(id);
    }
    */
=======

    @Override
    public void updateClassRoom(ClassroomDTO classroomDTO) {
        Classroom classroom = classroomRepository.findOne(classroomDTO.getRoomId());
        classroomMapper.mapToEntity(classroomDTO, classroom);
    }

    @Override
    public void addClassRoom(ClassroomDTO classroomDTO) {
        Classroom classroom = classroomMapper.toEntity(classroomDTO);
        classroomRepository.save(classroom);
    }

    @Override
    public void deleteClassRoomByID(String id) {
        classroomRepository.delete(id);
    }
>>>>>>> cb7af5c05017432d428b3dad165eca07f0bfd3db
}
