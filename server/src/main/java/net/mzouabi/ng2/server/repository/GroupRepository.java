package net.mzouabi.ng2.server.repository;
/**
 * Created by Jayani on 08/15/17.
 */

import org.springframework.data.repository.CrudRepository;
import net.mzouabi.ng2.server.model.GroupModel;


public interface GroupRepository extends CrudRepository<GroupModel, String> {
}