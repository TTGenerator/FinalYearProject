package net.mzouabi.ng2.server.mvc;
/**
 * Created by Jayani on 06/05/17.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import net.mzouabi.ng2.server.repository.RoleRepository;
import net.mzouabi.ng2.server.model.Role;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/userRole")
public class RoleController {

    @Autowired
    private RoleRepository userRoleRepository;

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Role> findAllUsers() {
        return userRoleRepository.findAll();
    }

}