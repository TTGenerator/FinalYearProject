package net.mzouabi.ng2.server.services;

import net.mzouabi.ng2.server.model.Response;
import net.mzouabi.ng2.server.model.Role;
import net.mzouabi.ng2.server.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jayani on 7/8/17.
 */
@Service
public class RoleService {

  @Autowired
  private RoleRepository userRoleRepository;

  public Iterable<Role> findAll() {
    return userRoleRepository.findAll();
  }

  public Role getUserByUsername(String name) {
    return userRoleRepository.findOne(name);
  }

  public Response checkUser(String name, String password) {
    Response response = new Response();

    response.setMessage("user invalid");
    Role resultUser = null;
    boolean isValiedUser = false;
    resultUser = userRoleRepository.findOne(name);
    if (password.equals(resultUser.password)) {
      isValiedUser = true;
      response.setMessage("user valid");
      response.setData(resultUser);
    }
    response.setValid(isValiedUser);
    return response;
  }
}
