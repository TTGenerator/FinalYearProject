package net.mzouabi.ng2.server.mvc;
/**
 * Created by Jayani on 06/05/17.
 */

import net.mzouabi.ng2.server.controllers.RoleController;
import net.mzouabi.ng2.server.model.Response;
import net.mzouabi.ng2.server.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.*;

import net.mzouabi.ng2.server.model.Role;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/userRole")
public class RoleControllerImpl implements RoleController {

  @Autowired
  private RoleService roleService;

  public Iterable<Role> findAllUsers() {
    return roleService.findAll();
  }

  public Role getUserByUsername(@RequestParam(Constants.NAME) String name) {
    return roleService.getUserByUsername(name);
  }

  public Response checkUser(@PathVariable(Constants.NAME) String name,
                            @PathVariable(Constants.PASSWORD) String password) {
    return roleService.checkUser(name, password);
  }

}