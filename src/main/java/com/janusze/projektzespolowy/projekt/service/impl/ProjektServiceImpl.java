package com.janusze.projektzespolowy.projekt.service.impl;

import com.janusze.projektzespolowy.projekt.dto.ProjektDTO;
import com.janusze.projektzespolowy.projekt.ob.ProjektOB;
import com.janusze.projektzespolowy.projekt.repository.IProjektRepository;
import com.janusze.projektzespolowy.projekt.service.IProjektService;
import com.janusze.projektzespolowy.user.dto.UserDTO;
import com.janusze.projektzespolowy.user.ob.UserOB;
import com.janusze.projektzespolowy.user.repository.IUserRepository;
import com.janusze.projektzespolowy.user.service.IUserService;
import com.janusze.projektzespolowy.util.converters.impl.ProjektConverter;
import com.janusze.projektzespolowy.util.converters.impl.UserConverter;
import com.janusze.projektzespolowy.util.wrappers.ProjektAndUserDTO;
import com.janusze.projektzespolowy.util.wrappers.ProjektAndUsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tomasz Jodko on 2016-04-15.
 */
@Service
@Transactional
public class ProjektServiceImpl implements IProjektService {
    @Autowired
    IProjektRepository iProjektRepository;
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    IUserService userService;
    @Autowired
    ProjektConverter projektConverter;
    @Autowired
    UserConverter userConverter;

    @Override
    public ProjektDTO findProjektById(Long aId){
        ProjektOB pProjektOB = iProjektRepository.findOne(aId);
        if(pProjektOB == null){
            return null;
        }
        return projektConverter.mapOBtoDTO(pProjektOB);
    }

    @Override
    public List<ProjektDTO> findAllProjekty(){
        List<ProjektDTO> pResult = new ArrayList<>();
        List<ProjektOB> pProjektList = iProjektRepository.findAll();
        for (ProjektOB projekt : pProjektList) {
            pResult.add(projektConverter.mapOBtoDTO(projekt));
        }
        return pResult;
    }

    @Override
    public List<ProjektDTO> findByUserId(Long aUserId){
        List<ProjektDTO> pResult = new ArrayList<>();
        List<ProjektOB> pProjektList = iProjektRepository.findByUserId(aUserId);
        for (ProjektOB schedule : pProjektList) {
            pResult.add(projektConverter.mapOBtoDTO(schedule));
        }
        return pResult;
    }

    @Override
    public ProjektDTO saveProjekt(ProjektDTO aProjektDTO){
        if(aProjektDTO == null){
            return null;
        }

        ProjektOB pProjektOB = aProjektDTO.getId() == null ? null : iProjektRepository.findOne(aProjektDTO.getId());

        if(pProjektOB == null){
            return projektConverter.mapOBtoDTO(iProjektRepository.save(projektConverter.mapDTOtoOB(aProjektDTO)));
        }

        pProjektOB.setNazwa(aProjektDTO.getNazwa());
        pProjektOB.setOpis(aProjektDTO.getOpis());
        pProjektOB.setWersja(aProjektDTO.getWersja());
        return projektConverter.mapOBtoDTO(pProjektOB);
    }



    @Override
    public ProjektDTO addUserToProjekt(ProjektAndUserDTO aWrapper){
        ProjektOB pProjektOB = iProjektRepository.findOne(aWrapper.getProjekt().getId());
        pProjektOB.getUsers().add(userConverter.mapDTOtoOB(userService.findUserById(aWrapper.getUser().getId())));
        return projektConverter.mapOBtoDTO(pProjektOB);
    }
    @Override
    public void setUsers(ProjektAndUsersDTO aWrapper){
        ProjektOB pProjektOB = iProjektRepository.findOne(aWrapper.getProjekt().getId());
        pProjektOB.setUsers(null);
        Set<UserOB> pUsers = new HashSet<>();
        for (UserDTO user:
             aWrapper.getUsers()) {
            UserOB pUserOB = userConverter.mapDTOtoOB(userService.findUserById(user.getId()));
            if(pUserOB!=null){
                pUsers.add(pUserOB);
            }
        }
        pProjektOB.setUsers(pUsers);
        iProjektRepository.save(pProjektOB);
    }

    @Override
    public ProjektDTO removeUserFromProjekt(ProjektAndUserDTO aWrapper){
        ProjektOB pProjektOB = iProjektRepository.findOne(aWrapper.getProjekt().getId());
        pProjektOB.getUsers().remove(userConverter.mapDTOtoOB(userService.findUserById(aWrapper.getUser().getId())));
        return projektConverter.mapOBtoDTO(pProjektOB);
    }

    @Override
    public void deleteProjekt(Long aId){
        iProjektRepository.delete(aId);
    }
}
