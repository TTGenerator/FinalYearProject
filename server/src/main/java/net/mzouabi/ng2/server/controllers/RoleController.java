package net.mzouabi.ng2.server.controllers;

import net.mzouabi.ng2.server.util.Response;
import net.mzouabi.ng2.server.model.Role;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jayani on 7/8/17.
 */

public interface RoleController {

  interface Constants {
    String NAME = "name";
    String PASSWORD = "password";
  }

  @ResponseBody
  @RequestMapping(value = "/getAllUsers",
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
  Iterable<Role> findAllUsers();

  @ResponseBody
  @RequestMapping(value = "/checkUser/{" + Constants.NAME + "}/{" + Constants.PASSWORD + "}",
    method = RequestMethod.GET)
  Response checkUser(String name, String password);

  @ResponseBody
  @RequestMapping(value = "/getUserByUsername",
    method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE)
  Role getUserByUsername(String name);
}
