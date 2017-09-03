/**
 * Created by jayani on 5/14/2017.
 */
package net.mzouabi.ng2.server.dto.tabu;
/**
 * Simple Room abstraction -- used to store the room capacity and compare against the student Group's size.
 */
public class Room {
    private final int roomid;
    private final String roomNumber;
    private final int capacity;

    /**
     * Initialize new Room
     *
     * @param roomid     The ID for this classroom
     * @param roomNumber The room number
     * @param capacity   The room capacity
     */
    public Room(int roomid, String roomNumber, int capacity) {
        this.roomid = roomid;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    /**
     * Return roomid
     *
     * @return roomid
     */
    public int getRoomid() {
        return this.roomid;
    }

    /**
     * Return room number
     *
     * @return roomNumber
     */
    public String getRoomNumber() {
        return this.roomNumber;
    }

    /**
     * Return room capacity
     *
     * @return capacity
     */
    public int getRoomCapacity() {
        return this.capacity;
    }
}