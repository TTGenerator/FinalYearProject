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
  @Column(name = "roomId")
  public String roomId;

  @Column(name = "roomName")
  public String roomName;

  @Column(name = "roomCategory")
  public String roomCategory;

  @Column(name = "capacity")
  public int capacity;

  @Column(name = "deleted")
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