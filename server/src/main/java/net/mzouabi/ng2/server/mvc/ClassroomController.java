package net.mzouabi.ng2.server.mvc;
/**
 * Created by Jayani on 06/05/17.
 */

import net.mzouabi.ng2.server.model.Classroom;
import net.mzouabi.ng2.server.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/addClassRoom", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addClassRoom(
            @RequestParam("room_id") String room_id,
            @RequestParam("room_name") String room_name,
            @RequestParam("room_category") String room_category,
            @RequestParam("capacity") String capacity,
            @RequestParam("is_deleted") String is_deleted) {

        System.out.println("get success");
        boolean deleted = false;
        if (is_deleted == "T") {
            deleted = true;
        }
        Classroom newClassroom = new Classroom(Integer.parseInt(room_id), room_name, room_category, Integer.parseInt(capacity), deleted);
        classroomRepository.save(newClassroom);
    }
    /*
    @RequestMapping(value = "/deleteClassRoomByID", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void deleteClassRoomByID(@RequestParam("room_id") int room_id) {
        Classroom resultClassroom = null;
        resultClassroom = classroomRepository.findOne(room_id);
        if (resultClassroom != null) {
            classroomRepository.delete(resultClassroom);
        } else {
            System.out.println("NULL");
        }
    }*/

    @RequestMapping(value = "/updateClassRoom", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void updateClassRoom(@RequestParam("room_id") String room_id,
                                @RequestParam("room_name") String room_name,
                                @RequestParam("room_category") String room_category,
                                @RequestParam("capacity") String capacity,
                                @RequestParam("is_deleted") String is_deleted) {

        if (classroomRepository.findOne(room_id) != null) {
            boolean deleted = false;
            if (is_deleted == "T") {
                deleted = true;
            }
            Classroom newClassroom = new Classroom(Integer.parseInt(room_id), room_name, room_category, Integer.parseInt(capacity), deleted);
            classroomRepository.save(newClassroom);
        } else {
            System.out.println("NULL");
        }
    }
}