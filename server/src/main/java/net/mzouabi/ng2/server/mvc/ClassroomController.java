package net.mzouabi.ng2.server.mvc;
/**
 * Created by Jayani on 06/05/17.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import net.mzouabi.ng2.server.repository.ClassroomRepository;
import net.mzouabi.ng2.server.model.Classroom;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomRepository classroomRepository;

    @RequestMapping(value = "/getAllClassrooms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Classroom> findAllClassroom() {
        return classroomRepository.findAll();
    }
/*
    @RequestMapping(value= "/DeleteClassroomByID/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ClassroomDTO> DeleteClassroomByID(@PathVariable String id) {
        //articleService.removeArticle(articleId);
    }
 */

    @RequestMapping(value = "/addClassRoom", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addClassRoom(
            @RequestParam("room_id") String room_id,
            @RequestParam("room_name") String room_name,
            @RequestParam("room_category") String room_category,
            @RequestParam("capacity") String capacity,
            @RequestParam("is_deleted") String is_deleted) {

        System.out.println("get success");
        Classroom newClassroom = new Classroom();
        newClassroom.setRoomId(room_id);
        newClassroom.setRoomName(room_name);
        newClassroom.setRoomCategory(room_category);
        newClassroom.setCapacity(Integer.parseInt(capacity));
        if(is_deleted=="T"){
            newClassroom.setIsDeleted(true);
        }else{
            newClassroom.setIsDeleted(false);
        }

        classroomRepository.save(newClassroom);
    }

    @RequestMapping(value = "/deleteClassRoomByID", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void deleteClassRoomByID(@RequestParam("room_id") String room_id) {
        Classroom resultClassroom = null;
        resultClassroom = classroomRepository.findOne(room_id);
        if(resultClassroom != null){
            classroomRepository.delete(resultClassroom);
        }else{
            System.out.println("NULL");
        }
    }

    @RequestMapping(value = "/updateClassRoom", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void updateClassRoom(@RequestParam("room_id") String room_id,
                                @RequestParam("room_name") String room_name,
                                @RequestParam("room_category") String room_category,
                                @RequestParam("capacity") String capacity,
                                @RequestParam("is_deleted") String is_deleted) {

        Classroom classroom = null;
        classroom = classroomRepository.findOne(room_id);
        if(classroom != null){
            classroom.setRoomName(room_name);
            classroom.setRoomCategory(room_category);
            classroom.setCapacity(Integer.parseInt(capacity));
            if(is_deleted=="T"){
                classroom.setIsDeleted(true);
            }else{
                classroom.setIsDeleted(false);
            }

            classroomRepository.save(classroom);
        }else{
            System.out.println("NULL");
        }
    }
}