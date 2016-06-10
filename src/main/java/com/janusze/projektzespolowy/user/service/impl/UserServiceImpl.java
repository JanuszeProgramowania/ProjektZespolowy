package com.janusze.projektzespolowy.user.service.impl;

import com.janusze.projektzespolowy.company.service.ICompanyService;
import com.janusze.projektzespolowy.projekt.dto.ProjektDTO;
import com.janusze.projektzespolowy.projekt.service.IProjektService;
import com.janusze.projektzespolowy.user.dto.UserDTO;
import com.janusze.projektzespolowy.user.dto.UserDetailsDTO;
import com.janusze.projektzespolowy.user.ob.UserOB;
import com.janusze.projektzespolowy.user.repository.IUserRepository;
import com.janusze.projektzespolowy.user.service.IUserService;
import com.janusze.projektzespolowy.util.converters.impl.CompanyConverter;
import com.janusze.projektzespolowy.util.converters.impl.UserConverter;
import com.janusze.projektzespolowy.util.enums.ETypUzytkownika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    ICompanyService companyService;
    @Autowired
    IProjektService projektService;
    @Autowired
    CompanyConverter companyConverter;



    @Override
    public UserDTO findUserById(Long aId) {
        UserOB pUserOB = iUserRepository.findOne(aId);
        if (pUserOB == null) {
            return null;
        }
        return userConverter.mapOBtoDTO(pUserOB);
    }

    @Override
    public List<UserDTO> findUsersByCompanyId(Long aCompanyId) {
        List<UserDTO> pResult = new ArrayList<>();
        List<UserOB> pUserList = iUserRepository.findByCompanyId(aCompanyId);
        for (UserOB user : pUserList) {
            pResult.add(userConverter.mapOBtoDTO(user));
        }
        return pResult;
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
    public UserDTO findUserByEmail(String email) {
        UserOB pUserOB = iUserRepository.findByEmail(email);
        if (pUserOB == null) {
            return null;
        }
        return userConverter.mapOBtoDTO(pUserOB);
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
            pUserOB = userConverter.mapDTOtoOB(aUserDTO);
            pUserOB.setPassword(new BCryptPasswordEncoder().encode(aUserDTO.getPassword()));
            if(aUserDTO.getCompany() != null) {
                pUserOB.setCompany(companyConverter.mapDTOtoOB(companyService.findCompanyById(aUserDTO.getCompany().getId())));
            }
            return userConverter.mapOBtoDTO(iUserRepository.save(pUserOB));
        }
        // edycja istniejacego
        pUserOB.setName(aUserDTO.getName());
        pUserOB.setLastName(aUserDTO.getLastName());
        pUserOB.setCompany(companyConverter.mapDTOtoOB(companyService.findCompanyById(aUserDTO.getCompany().getId())));
        pUserOB.setAuthority(aUserDTO.getAuthority());
        pUserOB.setAktywny(aUserDTO.isAktywny());
        pUserOB.setEmail(aUserDTO.getEmail());
        pUserOB.setTypUzytkownika(aUserDTO.getTypUzytkownika());


        return userConverter.mapOBtoDTO(iUserRepository.save(pUserOB));
    }

    @Override
    public List<UserDTO> findUsersInProjekt(Long aProjektId){
        ProjektDTO pProjektDTO = projektService.findProjektById(aProjektId);
        if(pProjektDTO != null){
            List<UserDTO> pProjektUsers = new ArrayList<>();
            pProjektUsers.addAll(pProjektDTO.getUsers());
            return pProjektUsers;
        }
        return null;
    }

    @Override
    public List<UserDTO> findUsersByUserType(ETypUzytkownika aType){
        List<UserDTO> pResult = new ArrayList<>();
        List<UserOB> pUserList = iUserRepository.findByUserType(aType);
        for (UserOB user : pUserList) {
            pResult.add(userConverter.mapOBtoDTO(user));
        }
        return pResult;
    }


    @Override
    public List<UserDTO> findUsersNotInProjekt(Long aProjektId){
        ProjektDTO pProjektDTO = projektService.findProjektById(aProjektId);
        if(pProjektDTO != null){
            List<UserDTO> pProjektUsers = new ArrayList<>();
            pProjektUsers.addAll(pProjektDTO.getUsers());
            List<UserDTO> pWewUsers = findUsersByUserType(ETypUzytkownika.WEWNETRZNY);
            pWewUsers.removeAll(pProjektUsers);

            return pWewUsers;
        }
        return null;
    }

    @Override
    public void changePassword(UserDetailsDTO aUserDetailsDTO, String aNewPassword) {
        UserOB pUserOB = iUserRepository.findOne(aUserDetailsDTO.getId());
        if (pUserOB != null) {
            pUserOB.setPassword(new BCryptPasswordEncoder().encode(aNewPassword));

        }
    }

    @Override
    public void deleteUser(Long aId) {
        iUserRepository.delete(aId);
    }
}
