package net.mzouabi.ng2.server.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Jayani on 05/30/17.
 */

@Entity
public class Classroom extends AbstractClassroomEntity {

    private static final long serialVersionUID = -6321180910534044216L;

    String room_id;

    String room_name;

    String room_category;

    int capacity;

    boolean is_active;

    boolean is_deleted;

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

    public boolean getIsActive() { return is_active; }

    public void setIsActive(boolean is_active) { this.is_active = is_active; }

    public boolean getIsDeleted() { return is_deleted; }

    public void setIsDeleted(boolean is_deleted) { this.is_deleted = is_deleted; }
}
