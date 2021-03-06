package com.janusze.projektzespolowy.zgloszenie.service;

import com.janusze.projektzespolowy.util.enums.ETypPriorytetu;
import com.janusze.projektzespolowy.util.wrappers.SaveZgloszenieDTO;
import com.janusze.projektzespolowy.zgloszenie.dto.ZgloszenieDTO;

import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-22.
 */
public interface IZgloszenieService {

    ZgloszenieDTO findZgloszenieById(Long aId);

    List<ZgloszenieDTO> findAllZgloszenia();

    ZgloszenieDTO saveZgloszenie(SaveZgloszenieDTO aWrapper);

    ZgloszenieDTO changeZgloszenie(ZgloszenieDTO aZgloszenieDTO);

    List<ZgloszenieDTO> findByUserId(Long aUserId);

    List<ZgloszenieDTO> findByProjektId(Long aProjektId);

    List<ZgloszenieDTO> findZewByProjektId(Long aProjektId);

    List<ZgloszenieDTO> findWewByProjektId(Long aProjektId);

    List<ZgloszenieDTO> findByPriorytetType(ETypPriorytetu aTypPriorytetu);

    List<ZgloszenieDTO> findByUserAndProjektId(Long aUserId,Long aProjektId);

    void deleteZgloszenie(Long aId);

}
