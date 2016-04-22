package com.janusze.projektzespolowy.priorytet.service;

import com.janusze.projektzespolowy.priorytet.dto.PriorytetDTO;

import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-22.
 */
public interface IPriorytetService {

    PriorytetDTO findPriorytetById(Long aId);

    List<PriorytetDTO> findAllPriorytety();

    PriorytetDTO savePriorytet(PriorytetDTO aPriorytetDTO);

    void deletePriorytet(Long aId);
}
