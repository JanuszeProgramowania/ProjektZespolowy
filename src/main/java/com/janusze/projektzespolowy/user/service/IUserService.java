package com.janusze.projektzespolowy.user.service;

import com.janusze.projektzespolowy.user.dto.UserDTO;

import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
public interface IUserService {

    UserDTO findUserById(Long aId);

    List<UserDTO> findAllUsers();

    UserDTO saveUser(UserDTO aUserDTO);

    void deleteUser(Long aId);
}
