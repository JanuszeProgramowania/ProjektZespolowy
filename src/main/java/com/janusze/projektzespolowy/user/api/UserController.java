package com.janusze.projektzespolowy.user.api;

import com.janusze.projektzespolowy.auth.UserAuthentication;
import com.janusze.projektzespolowy.user.dto.UserDTO;
import com.janusze.projektzespolowy.user.dto.UserDetailsDTO;
import com.janusze.projektzespolowy.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@RestController
@Transactional
@RequestMapping(value = "/projektzespolowy/users")
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public ResponseEntity<UserDetailsDTO> getCurrent() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof UserAuthentication) {
            return new ResponseEntity<>(((UserAuthentication) authentication).getDetails(), HttpStatus.OK);
        }
        return null;
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.PUT)
    public ResponseEntity<Void> changePassword(@RequestBody String aNewPassword) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof UserAuthentication) {
            UserDetailsDTO pUserDetailsDTO = ((UserAuthentication) authentication).getDetails();
            userService.changePassword(pUserDetailsDTO, aNewPassword);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return null;
    }

    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UserDTO> findUserById(@PathVariable("id") Long aId) {
        return new ResponseEntity<>(userService.findUserById(aId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "getByCompanyId/{companyId}", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findUsersByCompanyId(@PathVariable("companyId") Long aCompanyId) {
        return new ResponseEntity<>(userService.findUsersByCompanyId(aCompanyId), HttpStatus.OK);
    }

    @RequestMapping(value = "getUsersInProject/{projektId}", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getUsersInProjekt(@PathVariable("projektId") Long aProjektId) {
        return new ResponseEntity<>(userService.findUsersInProjekt(aProjektId), HttpStatus.OK);
    }

    @RequestMapping(value = "getUsersNotInProject/{projektId}", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getUsersNotInProjekt(@PathVariable("projektId") Long aProjektId) {
        return new ResponseEntity<>(userService.findUsersNotInProjekt(aProjektId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getByFullNames/{name},{lastName}", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findUsersByNames(@PathVariable("name") String aName, @PathVariable("lastName") String aLastName) {
        return new ResponseEntity<>(userService.findUsersByFullName(aName, aLastName), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO aUserDTO) {
        return new ResponseEntity<>(userService.saveUser(aUserDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long aId) {
        userService.deleteUser(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
