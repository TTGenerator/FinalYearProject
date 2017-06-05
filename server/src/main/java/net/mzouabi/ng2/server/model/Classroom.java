package net.mzouabi.ng2.server.model;
/**
 * Created by Jayani on 06/05/17.
 */
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Classroom")
public class Classroom {

    @Id
    @Column(name = "room_id")
    public String room_id;

    @Column(name = "room_name")
    public String room_name;

    @Column(name = "room_category")
    public String room_category;

    @Column(name = "capacity")
    public int capacity;

    @Column(name = "is_deleted")
    public boolean is_deleted;

    public String getRoomId() { return room_id; }

    public void setRoomId(String room_id) { this.room_id = room_id; }

    public String getRoomName() { return room_name; }

    public void setRoomName(String room_name) { this.room_name = room_name; }

    public String getRoomCategory() { return room_category; }

    public void setRoomCategory(String room_category) { this.room_category = room_category; }

    public int getCapacity() { return capacity;}

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public boolean getIsDeleted() { return is_deleted; }

    public void setIsDeleted(boolean is_deleted) { this.is_deleted = is_deleted; }

}