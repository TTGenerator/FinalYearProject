package net.mzouabi.ng2.server.model;
/**
 * Created by Jayani on 06/05/17.
 */

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CLASSROOM")
public class Classroom {

  @Id
  @Column(name = "room_id")
  public String roomId;

  @Column(name = "room_name")
  public String roomName;

  @Column(name = "room_category")
  public String roomCategory;

  @Column(name = "capacity")
  public int capacity;

  @Column(name = "is_deleted")
  public boolean deleted;

  public Classroom(String roomId, String roomName, String roomCategory, int capacity, boolean deleted) {
    this.roomId = roomId;
    this.roomName = roomName;
    this.roomCategory = roomCategory;
    this.capacity = capacity;
    this.deleted = deleted;
  }

  public Classroom() {
  }
}