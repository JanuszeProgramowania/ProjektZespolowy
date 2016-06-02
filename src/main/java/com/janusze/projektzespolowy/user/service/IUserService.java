package com.janusze.projektzespolowy.user.service;

import com.janusze.projektzespolowy.user.dto.UserDTO;

import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
public interface IUserService {

    UserDTO findUserById(Long aId);

    List<UserDTO> findAllUsers();

    List<UserDTO> findUsersByFullName(String aName, String aLastName);

    UserDTO saveUser(UserDTO aUserDTO);

    UserDTO findUserByEmail(String email);

    void deleteUser(Long aId);
}
