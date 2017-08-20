package net.mzouabi.ng2.server.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by jayani on 7/16/17.
 */
@Data
@Entity
@Table(name = "LecturerPreferences")
public class LecturePreferences {
  @Id
  @Column(name = "lecturer_id")
  private String lectureId;

  @Column(name = "is_ac")
  private boolean isAc;

  @Column(name = "has_multimedia")
  private boolean hasMultimedia;

  @Column(name = "has_whiteboard")
  private boolean hasWhiteboard;

  public LecturePreferences() {
  }

  public LecturePreferences(String lectureId, boolean isAc, boolean hasMultimedia, boolean hasWhiteboard) {
    this.lectureId = lectureId;
    this.isAc = isAc;
    this.hasMultimedia = hasMultimedia;
    this.hasWhiteboard = hasWhiteboard;
  }
}
