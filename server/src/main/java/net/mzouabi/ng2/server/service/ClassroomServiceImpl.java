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
    public Page<ClassroomDTO> findClassrooms(Pageable pageable) {
        return classroomRepository.findAll(pageable).map(classroom -> classroomMapper.toDTO(classroom));
    }

    @Override
    public ClassroomDTO getClassroomByID(String id) {
        return classroomMapper.toDTO(classroomRepository.getOne(id));
    }

}
