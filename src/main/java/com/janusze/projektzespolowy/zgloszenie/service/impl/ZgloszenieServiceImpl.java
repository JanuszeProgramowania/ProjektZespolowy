package com.janusze.projektzespolowy.zgloszenie.service.impl;

import com.janusze.projektzespolowy.priorytet.dto.PriorytetDTO;
import com.janusze.projektzespolowy.priorytet.ob.PriorytetOB;
import com.janusze.projektzespolowy.priorytet.service.IPriorytetService;
import com.janusze.projektzespolowy.projekt.dto.ProjektDTO;
import com.janusze.projektzespolowy.projekt.ob.ProjektOB;
import com.janusze.projektzespolowy.projekt.service.IProjektService;
import com.janusze.projektzespolowy.user.dto.UserDTO;
import com.janusze.projektzespolowy.user.ob.UserOB;
import com.janusze.projektzespolowy.user.service.IUserService;
import com.janusze.projektzespolowy.util.converters.impl.PriorytetConverter;
import com.janusze.projektzespolowy.util.converters.impl.ProjektConverter;
import com.janusze.projektzespolowy.util.converters.impl.UserConverter;
import com.janusze.projektzespolowy.util.converters.impl.ZgloszenieConverter;
import com.janusze.projektzespolowy.util.enums.ETypPriorytetu;
import com.janusze.projektzespolowy.util.wrappers.SaveZgloszenieDTO;
import com.janusze.projektzespolowy.zgloszenie.dto.ZgloszenieDTO;
import com.janusze.projektzespolowy.zgloszenie.ob.ZgloszenieOB;
import com.janusze.projektzespolowy.zgloszenie.repository.IZgloszenieRepository;
import com.janusze.projektzespolowy.zgloszenie.service.IZgloszenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-22.
 */
@Service
@Transactional
public class ZgloszenieServiceImpl implements IZgloszenieService{

    @Autowired
    IZgloszenieRepository iZgloszenieRepository;
    @Autowired
    ZgloszenieConverter zgloszenieConverter;
    @Autowired
    IUserService userService;
    @Autowired
    UserConverter userConverter;
    @Autowired
    IPriorytetService priorytetService;
    @Autowired
    PriorytetConverter priorytetConverter;
    @Autowired
    IProjektService projektService;
    @Autowired
    ProjektConverter projektConverter;


    @Override
    public ZgloszenieDTO findZgloszenieById(Long aId) {
        ZgloszenieOB pZgloszenieOB = iZgloszenieRepository.findOne(aId);
        if (pZgloszenieOB == null) {
            return null;
        }
        return zgloszenieConverter.mapOBtoDTO(pZgloszenieOB);
    }

    @Override
    public List<ZgloszenieDTO> findAllZgloszenia() {
        List<ZgloszenieDTO> pResult = new ArrayList<>();
        List<ZgloszenieOB> pZgloszenieList = iZgloszenieRepository.findAll();
        for (ZgloszenieOB zgloszenie : pZgloszenieList) {
            pResult.add(zgloszenieConverter.mapOBtoDTO(zgloszenie));
        }
        return pResult;
    }

    @Override
    public ZgloszenieDTO saveZgloszenie(SaveZgloszenieDTO aWrapper) {
        ZgloszenieDTO pZgloszenieDTO = aWrapper.getZgloszenie();
        UserDTO pUserDTO = aWrapper.getUser();
        PriorytetDTO pPriorytetDTO = aWrapper.getPriorytet();
        ProjektDTO pProjektDTO = aWrapper.getProjekt();
        if (pZgloszenieDTO == null || pUserDTO == null || pPriorytetDTO == null || pProjektDTO == null) {
            return null;
        }
        ZgloszenieOB pZgloszenieOB = iZgloszenieRepository.findOne(pZgloszenieDTO.getId());
        if (pZgloszenieOB == null) {
            UserOB pUserOB = userConverter.mapDTOtoOB(userService.findUserById(pUserDTO.getId()));
            PriorytetOB pPriorytetOB = priorytetConverter.mapDTOtoOB(priorytetService.findPriorytetById(pPriorytetDTO.getId()));
            ProjektOB pProjektOB = projektConverter.mapDTOtoOB(projektService.findProjektById(pProjektDTO.getId()));
            pZgloszenieOB = zgloszenieConverter.mapDTOtoOB(pZgloszenieDTO);
            pZgloszenieOB.setUser(pUserOB);
            pZgloszenieOB.setPriorytet(pPriorytetOB);
            pZgloszenieOB.setProjekt(pProjektOB);
            return zgloszenieConverter.mapOBtoDTO(iZgloszenieRepository.save(pZgloszenieOB));
        }
        pZgloszenieOB.setOpis(pZgloszenieDTO.getOpis());
        pZgloszenieOB.setStatus(pZgloszenieDTO.getStatus());
        pZgloszenieOB.setZgloszenieWewZew(pZgloszenieDTO.getZgloszenieWewZew());
        pZgloszenieOB.setTypZgloszenia(pZgloszenieDTO.getTypZgloszenia());
        return zgloszenieConverter.mapOBtoDTO(iZgloszenieRepository.save(pZgloszenieOB));
    }

    @Override
    public List<ZgloszenieDTO> findByUserId(Long aUserId) {
        List<ZgloszenieDTO> pResult = new ArrayList<>();
        List<ZgloszenieOB> pZgloszenieList = iZgloszenieRepository.findByUserId(aUserId);
        for (ZgloszenieOB zgloszenie : pZgloszenieList) {
            pResult.add(zgloszenieConverter.mapOBtoDTO(zgloszenie));
        }
        return pResult;
    }

    @Override
    public List<ZgloszenieDTO> findByProjektId(Long aUserId) {
        List<ZgloszenieDTO> pResult = new ArrayList<>();
        List<ZgloszenieOB> pZgloszenieList = iZgloszenieRepository.findByProjektId(aUserId);
        for (ZgloszenieOB zgloszenie : pZgloszenieList) {
            pResult.add(zgloszenieConverter.mapOBtoDTO(zgloszenie));
        }
        return pResult;
    }

    @Override
    public List<ZgloszenieDTO> findByPriorytetType(ETypPriorytetu aTypPriorytetu) {
        List<ZgloszenieDTO> pResult = new ArrayList<>();
        List<ZgloszenieOB> pZgloszenieList = iZgloszenieRepository.findByPriorytetType(aTypPriorytetu);
        for (ZgloszenieOB zgloszenie : pZgloszenieList) {
            pResult.add(zgloszenieConverter.mapOBtoDTO(zgloszenie));
        }
        return pResult;
    }

    @Override
    public void deleteZgloszenie(Long aId) {
        iZgloszenieRepository.delete(aId);
    }
}
