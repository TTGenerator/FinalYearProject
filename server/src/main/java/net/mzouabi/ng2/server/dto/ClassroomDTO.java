package net.mzouabi.ng2.server.dto;

import java.util.Date;

/**
 * Created by Jayani on 05/30/17.
 */
public class ClassroomDTO extends AbstractClassroomDTO {

    private String room_id;

    private String room_name;

    private String room_category;

    private int capacity;

    private boolean is_deleted;

    public String getRoomId() {
        return room_id;
    }

    public void setRoomId(String room_id) {
        this.room_id = room_id;
    }

    public String getRoomName() {
        return room_name;
    }

    public void setRoomName(String room_name) { this.room_name = room_name; }

    public String getRoomCategory() {
        return room_category;
    }

    public void setRoomCategory(String room_category) { this.room_category = room_category; }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public boolean getIsDeleted() { return is_deleted; }

    public void setIsDeleted(boolean is_deleted) { this.is_deleted = is_deleted; }

}
