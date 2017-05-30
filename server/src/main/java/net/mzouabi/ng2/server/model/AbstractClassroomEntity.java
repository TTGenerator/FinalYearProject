package net.mzouabi.ng2.server.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

/**
 * Created by Jayani on 05/30/17.
 */
@MappedSuperclass
public class AbstractClassroomEntity implements Serializable {

    @Id
    @GeneratedValue
    private String room_id;

    public String getRoomId() {
        return room_id;
    }

    public void setRoomId(String room_id) {
        this.room_id = room_id;
    }

}
