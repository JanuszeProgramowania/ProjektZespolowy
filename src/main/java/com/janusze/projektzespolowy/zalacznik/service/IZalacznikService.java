package com.janusze.projektzespolowy.zalacznik.service;

import com.janusze.projektzespolowy.util.wrappers.SaveZalacznikDTO;
import com.janusze.projektzespolowy.zalacznik.dto.ZalacznikDTO;

import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-22.
 */
public interface IZalacznikService {

    ZalacznikDTO findZalacznikById(Long aId);

    List<ZalacznikDTO> findAllZalacznik();

    ZalacznikDTO saveZalacznik(SaveZalacznikDTO aWrapper);

    List<ZalacznikDTO> findByHistoriaId(Long aHistoriaId);

    void deleteZalacznik(Long aId);
}
