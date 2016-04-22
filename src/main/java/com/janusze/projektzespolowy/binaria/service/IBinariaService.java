package com.janusze.projektzespolowy.binaria.service;

import com.janusze.projektzespolowy.binaria.dto.BinariaDTO;

import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-22.
 */
public interface IBinariaService {

    BinariaDTO findBinariaById(Long aId);

    List<BinariaDTO> findAllBinaria();

    BinariaDTO saveBinaria(BinariaDTO aBinariaDTO);

    void deleteBinaria(Long aId);
}
