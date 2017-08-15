
package net.mzouabi.ng2.server.model;
/**
 * Created by Jayani on 08/15/17.
 */
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class GroupModel {

    @Id
    @Column(name = "group_id")
    public int groupId;

    @Column(name = "group_size")
    public int group_size;

    public int getGroupId() { return groupId; }

    public void setGroupId(int groupId) { this.groupId = groupId; }

    public int getGroup_size() { return group_size; }

    public void setGroup_size(int group_size) { this.group_size = group_size; }

}