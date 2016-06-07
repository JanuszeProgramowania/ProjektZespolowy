package com.janusze.projektzespolowy.projekt.service;

import com.janusze.projektzespolowy.projekt.dto.ProjektDTO;
import com.janusze.projektzespolowy.util.wrappers.ProjektAndCompaniesDTO;
import com.janusze.projektzespolowy.util.wrappers.ProjektAndUserDTO;
import com.janusze.projektzespolowy.util.wrappers.ProjektAndUsersDTO;

import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-15.
 */
public interface IProjektService {

    ProjektDTO findProjektById(Long aId);

    List<ProjektDTO> findAllProjekty();

    ProjektDTO saveProjekt(ProjektDTO aProjektDTO);

    ProjektDTO addUserToProjekt(ProjektAndUserDTO aWrapper);

    ProjektDTO removeUserFromProjekt(ProjektAndUserDTO aWrapper);

    List<ProjektDTO> findByUserId(Long aUserId);

    List<ProjektDTO> findByCompanyId(Long aCompanyId);

    void setUsers(ProjektAndUsersDTO aWrapper);

    void setCompanies(ProjektAndCompaniesDTO aWrapper);

    void deleteProjekt(Long aId);

}
