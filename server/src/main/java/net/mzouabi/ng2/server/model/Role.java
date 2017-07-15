package net.mzouabi.ng2.server.model;
/**
 * Created by Jayani on 06/14/17.
 */

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Role")
public class Role {

  @Id
  @Column(name = "name")
  public String name;

  @Column(name = "role")
  public String role;

  @Column(name = "password")
  public String password;

}
