package com.janusze.projektzespolowy.user.api;

import com.janusze.projektzespolowy.user.dto.UserDTO;
import com.janusze.projektzespolowy.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
