package net.mzouabi.ng2.server.model;
/**
 * Created by Jayani on 06/05/17.
 */
import javax.persistence.*;



@Entity
@Table(name = "Classroom")
public class Classroom {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "roomid")
    public int roomid;

    @Column(name = "roomname")
    public String roomname;

    @Column(name = "room_category")
    public String room_category;

    @Column(name = "capacity")
    public int capacity;

    @Column(name = "is_deleted")
    public boolean is_deleted;

    public int getRoomid() { return roomid; }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public String getRoomname() { return roomname; }

    public void setRoomname(String roomname) { this.roomname = roomname; }

    public String getRoom_category() { return room_category; }

    public void setRoom_category(String room_category) { this.room_category = room_category; }

    public int getCapacity() { return capacity;}

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public boolean getIs_deleted() { return is_deleted; }

    public void setIs_deleted(boolean is_deleted) { this.is_deleted = is_deleted; }

}