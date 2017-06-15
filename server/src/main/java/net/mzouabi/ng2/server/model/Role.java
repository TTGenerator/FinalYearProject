package net.mzouabi.ng2.server.model;
/**
 * Created by Jayani on 06/14/17.
 */
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

}