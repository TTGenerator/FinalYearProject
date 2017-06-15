package net.mzouabi.ng2.server.repository;
/**
 * Created by Jayani on 06/14/17.
 */

import org.springframework.data.repository.CrudRepository;
import net.mzouabi.ng2.server.model.Role;


public interface RoleRepository extends CrudRepository<Role, String> {

}