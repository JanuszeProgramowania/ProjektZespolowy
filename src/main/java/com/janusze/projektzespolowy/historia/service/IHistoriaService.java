package com.janusze.projektzespolowy.historia.service;

import com.janusze.projektzespolowy.historia.dto.HistoriaDTO;
import com.janusze.projektzespolowy.util.wrappers.SaveHistoriaDTO;

import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-22.
 */
public interface IHistoriaService {
    HistoriaDTO findHistoriaById(Long aId);

    List<HistoriaDTO> findAllHistoria();

    HistoriaDTO saveHistoria(SaveHistoriaDTO aWrapper);

    List<HistoriaDTO> findByUserId(Long aUserId);

    List<HistoriaDTO> findByZgloszenieId(Long aZgloszenieId);

    void deleteHistoria(Long aId);
}
