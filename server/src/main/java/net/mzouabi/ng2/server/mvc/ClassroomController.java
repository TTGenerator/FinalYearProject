package net.mzouabi.ng2.server.mvc;

import net.mzouabi.ng2.server.dto.ClassroomDTO;
import net.mzouabi.ng2.server.service.ClassroomService;
import net.mzouabi.ng2.server.model.Classroom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import java.util.List;
/**
 * Created by Jayani on 05/30/17.
 */

@RestController
@CrossOrigin
@RequestMapping(value = "/api/classroom")
public class ClassroomController {

    final static Logger LOG = LoggerFactory.getLogger(ClassroomController.class);

    @Inject
    ClassroomService classroomService;

    @RequestMapping(value = "/getAllClassrooms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Classroom>> findAllClassroom(Pageable pageable, HttpServletRequest req) {
        List<Classroom> classroom = classroomService.findClassrooms(pageable);
        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }

    @RequestMapping(value = "/getClassroomByID/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClassroomDTO> getClassroomByID(@PathVariable String id, HttpServletRequest req) {
        ClassroomDTO classroom = classroomService.getClassroomByID(id);
        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }

    @RequestMapping(value = "/addClassRoom", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addClassRoom(@RequestBody ClassroomDTO classroomDTO) {
        classroomService.addClassRoom(classroomDTO);
    }

    @RequestMapping(value = "/updateClassRoom", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateClassRoom(@RequestBody ClassroomDTO classroomDTO) {
        classroomService.updateClassRoom(classroomDTO);
    }

    @RequestMapping(value = "/deleteClassRoomByID/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteClassRoomByID(@PathVariable String id) {
        classroomService.deleteClassRoomByID(id);
    }

}

