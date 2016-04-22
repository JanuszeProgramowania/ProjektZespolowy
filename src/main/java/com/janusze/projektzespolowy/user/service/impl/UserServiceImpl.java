package com.janusze.projektzespolowy.user.service.impl;

import com.janusze.projektzespolowy.user.dto.UserDTO;
import com.janusze.projektzespolowy.user.ob.UserOB;
import com.janusze.projektzespolowy.user.repository.IUserRepository;
import com.janusze.projektzespolowy.user.service.IUserService;
import com.janusze.projektzespolowy.util.converters.impl.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService{
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    UserConverter userConverter;



    @Override
    public UserDTO findUserById(Long aId) {
        UserOB pUserOB = iUserRepository.findOne(aId);
        if (pUserOB == null) {
            return null;
        }
        return userConverter.mapOBtoDTO(pUserOB);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<UserDTO> pResult = new ArrayList<>();
        List<UserOB> pUserList = iUserRepository.findAll();
        for (UserOB user : pUserList) {
            pResult.add(userConverter.mapOBtoDTO(user));
        }
        return pResult;
    }


    @Override
    public List<UserDTO> findUsersByFullName(String aName, String aLastName) {
        List<UserDTO> pResult = new ArrayList<>();
        List<UserOB> pUserList = iUserRepository.findByFullName(aName, aLastName);
        for (UserOB user : pUserList) {
            pResult.add(userConverter.mapOBtoDTO(user));
        }
        return pResult;
    }

    @Override
    public UserDTO saveUser(UserDTO aUserDTO) {
        if (aUserDTO == null) {
            return null;
        }
        // sprawdzenie czy rekord juz istnieje
        UserOB pUserOB = aUserDTO.getId() == null ? null : iUserRepository.findOne(aUserDTO.getId());
        // zapis nowego
        if (pUserOB == null) {
            return userConverter.mapOBtoDTO(iUserRepository.save(userConverter.mapDTOtoOB(aUserDTO)));
        }
        // edycja istniejacego
        pUserOB.setImie(aUserDTO.getImie());
        pUserOB.setNazwisko(aUserDTO.getNazwisko());

        return userConverter.mapOBtoDTO(iUserRepository.save(pUserOB));
    }



    @Override
    public void deleteUser(Long aId) {
        iUserRepository.delete(aId);
    }
}
