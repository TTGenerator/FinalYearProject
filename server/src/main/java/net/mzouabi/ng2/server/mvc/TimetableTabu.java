/**
 * Created by jayani on 5/14/2017.
 */

package net.mzouabi.ng2.server.mvc;

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

import org.coinor.opents.*;
import net.mzouabi.ng2.server.dto.tabu.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
@RestController
@CrossOrigin
@RequestMapping(value = "/api/timetable")
public class TimetableTabu{

    public int numClassRooms;
    public int numTimeSlots;
    public int[][] initialSolutionMatrix;
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void mainmethod() {
        // Get a Timetable object with all the available information.
        Timetable timetable = initializeTimetable();
        System.out.println(this.numClassRooms);
        System.out.println(this.numTimeSlots);

        // Initialize object
        createTimetableMatrix();

        //Initial solution
        createInitialSolution();
    }


    public Timetable initializeTimetable() {
        // Create timetable
        Timetable timetable = new Timetable();

        // Set up rooms
        timetable.addRoom(1, "A1", 15);
        timetable.addRoom(2, "B1", 30);
        timetable.addRoom(4, "D1", 20);
        timetable.addRoom(5, "F1", 25);

        // Set up timeslots
        timetable.addTimeslot(1, "Mon 9:00 - 11:00");
        timetable.addTimeslot(2, "Mon 11:00 - 13:00");
        timetable.addTimeslot(3, "Mon 13:00 - 15:00");
        timetable.addTimeslot(4, "Tue 9:00 - 11:00");
        timetable.addTimeslot(5, "Tue 11:00 - 13:00");
        timetable.addTimeslot(6, "Tue 13:00 - 15:00");
        timetable.addTimeslot(7, "Wed 9:00 - 11:00");
        timetable.addTimeslot(8, "Wed 11:00 - 13:00");
        timetable.addTimeslot(9, "Wed 13:00 - 15:00");
        timetable.addTimeslot(10, "Thu 9:00 - 11:00");
        timetable.addTimeslot(11, "Thu 11:00 - 13:00");
        timetable.addTimeslot(12, "Thu 13:00 - 15:00");
        timetable.addTimeslot(13, "Fri 9:00 - 11:00");
        timetable.addTimeslot(14, "Fri 11:00 - 13:00");
        timetable.addTimeslot(15, "Fri 13:00 - 15:00");

        // Set up professors
        timetable.addProfessor(1, "Dr P Smith");
        timetable.addProfessor(2, "Mrs E Mitchell");
        timetable.addProfessor(3, "Dr R Williams");
        timetable.addProfessor(4, "Mr A Thompson");

        // Set up courses and define the professors that teach them
        timetable.addCourse(1, "cs1", "Computer Science", new int[]{1, 2});
        timetable.addCourse(2, "en1", "English", new int[]{1, 3});
        timetable.addCourse(3, "ma1", "Maths", new int[]{1, 2});
        timetable.addCourse(4, "ph1", "Physics", new int[]{3, 4});
        timetable.addCourse(5, "hi1", "History", new int[]{4});
        timetable.addCourse(6, "dr1", "Drama", new int[]{1, 4});

        // Set up student groups and the courses they take.
        timetable.addGroup(1, 10, new int[]{1, 3, 4});
        timetable.addGroup(2, 30, new int[]{2, 3, 5, 6});
        timetable.addGroup(3, 18, new int[]{3, 4, 5});
        timetable.addGroup(4, 25, new int[]{1, 4});
        timetable.addGroup(5, 20, new int[]{2, 3, 5});
        timetable.addGroup(6, 22, new int[]{1, 4, 5});
        timetable.addGroup(7, 16, new int[]{1, 3});
        timetable.addGroup(8, 18, new int[]{2, 6});
        timetable.addGroup(9, 24, new int[]{1, 6});
        timetable.addGroup(10, 25, new int[]{3, 4});

        this.numClassRooms = timetable.getRooms().size();
        this.numTimeSlots = timetable.getTimeslots().size();
        return timetable;
    }

    public void createTimetableMatrix(){
        int row = this.numClassRooms;
        int column = this.numTimeSlots;
        this.initialSolutionMatrix = new int[row][column];
    }

    public void createInitialSolution(){
        try {
            JSONParser parser = new JSONParser();
            Object  initialArray;
            initialArray = parser.parse(new FileReader("E://FYP/JSON.txt"));
            System.out.println(initialArray);
        } catch (ParseException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (ClassCastException e) {
            e.printStackTrace();
        }
    }
}