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
    public int addClassRoom(
//            @RequestParam("roomid") String roomid,
            @RequestParam("roomname") String roomname,
            @RequestParam("room_category") String room_category,
            @RequestParam("capacity") String capacity,
            @RequestParam("is_deleted") String is_deleted) {

        System.out.println("get success");
        boolean deleted = false;
        if (is_deleted == "T") {
            deleted = true;
        }
        Classroom newClassroom = new Classroom();
        newClassroom.setRoomid(0);
        newClassroom.setRoomname(roomname);
        newClassroom.setRoom_category(room_category);
        newClassroom.setCapacity(Integer.parseInt(capacity));
        newClassroom.setIs_deleted(deleted);
        classroomRepository.save(newClassroom);
        return newClassroom.getRoomid();
    }

    @RequestMapping(value = "/deleteClassRoomByID", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void deleteClassRoomByID(@RequestParam("roomid") String data) {
        int roomid = Integer.parseInt(data);
        Classroom resultClassroom = null;
        resultClassroom = classroomRepository.findByRoomid(roomid);
        System.out.println(resultClassroom);
        if (resultClassroom != null) {
            classroomRepository.delete(resultClassroom);
        } else {
            System.out.println("NULL");
        }
    }

    @RequestMapping(value = "/updateClassRoom", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void updateClassRoom(@RequestParam("roomid") String data,
                                @RequestParam("roomname") String roomname,
                                @RequestParam("room_category") String room_category,
                                @RequestParam("capacity") String capacity,
                                @RequestParam("is_deleted") String is_deleted) {
        int roomid = Integer.parseInt(data);
        if (classroomRepository.findByRoomid(roomid) != null) {
            boolean deleted = false;
            if (is_deleted == "T") {
                deleted = true;
            }
            Classroom newClassroom = new Classroom();
            newClassroom.setRoomid(roomid);
            newClassroom.setRoomname(roomname);
            newClassroom.setRoom_category(room_category);
            newClassroom.setCapacity(Integer.parseInt(capacity));
            newClassroom.setIs_deleted(deleted);
            classroomRepository.save(newClassroom);
        } else {
            System.out.println("NULL");
        }
    }
}