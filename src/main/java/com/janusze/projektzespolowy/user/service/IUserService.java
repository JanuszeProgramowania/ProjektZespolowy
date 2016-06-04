package com.janusze.projektzespolowy.user.service;

import com.janusze.projektzespolowy.user.dto.UserDTO;
import com.janusze.projektzespolowy.user.dto.UserDetailsDTO;
import com.janusze.projektzespolowy.util.enums.ETypUzytkownika;

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

    List<UserDTO> findUsersByCompanyId(Long aId);

    List<UserDTO> findUsersByUserType(ETypUzytkownika aType);

    List<UserDTO> findUsersInProjekt(Long aProjektId);

    List<UserDTO> findUsersNotInProjekt(Long aProjektId);

    void changePassword(UserDetailsDTO aUserDetailsDTO, String aNewPassword);

    void deleteUser(Long aId);
}
