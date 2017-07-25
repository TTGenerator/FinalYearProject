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
    @RequestParam("roomId") String roomId,
    @RequestParam("roomName") String roomName,
    @RequestParam("roomCategory") String roomCategory,
    @RequestParam("capacity") String capacity,
    @RequestParam("deleted") String deleted) {

    System.out.println("get success");
    boolean is_deleted = false;
    if (deleted == "T") {
      is_deleted = true;
    }
    Classroom newClassroom = new Classroom(roomId, roomName, roomCategory, Integer.parseInt(capacity), is_deleted);
    classroomRepository.save(newClassroom);
  }

  @RequestMapping(value = "/deleteClassRoomByID", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public void deleteClassRoomByID(@RequestParam("roomId") String roomId) {
    Classroom resultClassroom = null;
    resultClassroom = classroomRepository.findOne(roomId);
    if (resultClassroom != null) {
      classroomRepository.delete(resultClassroom);
    } else {
      System.out.println("NULL");
    }
  }

  @RequestMapping(value = "/updateClassRoom", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public void updateClassRoom(@RequestParam("roomId") String roomId,
                              @RequestParam("roomName") String roomName,
                              @RequestParam("roomCategory") String roomCategory,
                              @RequestParam("capacity") String capacity,
                              @RequestParam("deleted") String deleted) {

    if (classroomRepository.findOne(roomId) != null) {
      boolean is_deleted = false;
      if (deleted == "T") {
        is_deleted = true;
      }
      Classroom newClassroom = new Classroom(roomId, roomName, roomCategory, Integer.parseInt(capacity), is_deleted);
      classroomRepository.save(newClassroom);
    } else {
      System.out.println("NULL");
    }
  }
}