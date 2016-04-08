package com.janusze.projektzespolowy.user.service.impl;

import com.janusze.projektzespolowy.historia.dto.HistoriaDTO;
import com.janusze.projektzespolowy.historia.ob.HistoriaOB;
import com.janusze.projektzespolowy.projekt.dto.ProjektDTO;
import com.janusze.projektzespolowy.projekt.ob.ProjektOB;
import com.janusze.projektzespolowy.rola.dto.RolaDTO;
import com.janusze.projektzespolowy.rola.ob.RolaOB;
import com.janusze.projektzespolowy.user.dto.UserDTO;
import com.janusze.projektzespolowy.user.ob.UserOB;
import com.janusze.projektzespolowy.user.repository.IUserRepository;
import com.janusze.projektzespolowy.user.service.IUserService;
import com.janusze.projektzespolowy.util.converters.impl.*;
import com.janusze.projektzespolowy.zgloszenie.dto.ZgloszenieDTO;
import com.janusze.projektzespolowy.zgloszenie.ob.ZgloszenieOB;
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
    @Autowired
    ProjektConverter projektConverter;
    @Autowired
    RolaConverter rolaConverter;
    @Autowired
    HistoriaConverter historiaConverter;
    @Autowired
    ZgloszenieConverter zgloszenieConverter;


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
        pUserOB.setAktywny(aUserDTO.isAktywny());
        pUserOB.setEmail(aUserDTO.getEmail());
        pUserOB.setPasswordMd5(aUserDTO.getPasswordMd5());

        List<ProjektOB> pProjekty = new ArrayList<ProjektOB>();
        for (ProjektDTO projekt :
                aUserDTO.getProjekty()) {
            pProjekty.add(projektConverter.mapDTOtoOB(projekt));
        }
        pUserOB.setProjekty(pProjekty);

        List<RolaOB> pRole = new ArrayList<RolaOB>();
        for (RolaDTO rola :
                aUserDTO.getRole()) {
            pRole.add(rolaConverter.mapDTOtoOB(rola));
        }
        pUserOB.setRole(pRole);

        List<HistoriaOB> pHistoria = new ArrayList<HistoriaOB>();
        for (HistoriaDTO historia :
                aUserDTO.getHistoria()) {
            pHistoria.add(historiaConverter.mapDTOtoOB(historia));
        }
        pUserOB.setHistoria(pHistoria);

        pUserOB.setTypUzytkownika(aUserDTO.getTypUzytkownika());

        List<ZgloszenieOB> pZgloszenia = new ArrayList<ZgloszenieOB>();
        for (ZgloszenieDTO zgloszenie :
                aUserDTO.getZgloszenia()) {
            pZgloszenia.add(zgloszenieConverter.mapDTOtoOB(zgloszenie));
        }
        pUserOB.setZgloszenia(pZgloszenia);

        return userConverter.mapOBtoDTO(iUserRepository.save(pUserOB));
    }



    @Override
    public void deleteUser(Long aId) {
        iUserRepository.delete(aId);
    }
}
