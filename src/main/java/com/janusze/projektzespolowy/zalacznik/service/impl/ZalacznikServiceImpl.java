package com.janusze.projektzespolowy.zalacznik.service.impl;

import com.janusze.projektzespolowy.binaria.dto.BinariaDTO;
import com.janusze.projektzespolowy.binaria.ob.BinariaOB;
import com.janusze.projektzespolowy.binaria.service.IBinariaService;
import com.janusze.projektzespolowy.historia.dto.HistoriaDTO;
import com.janusze.projektzespolowy.historia.ob.HistoriaOB;
import com.janusze.projektzespolowy.historia.service.IHistoriaService;
import com.janusze.projektzespolowy.util.converters.impl.BinariaConverter;
import com.janusze.projektzespolowy.util.converters.impl.HistoriaConverter;
import com.janusze.projektzespolowy.util.converters.impl.ZalacznikConverter;
import com.janusze.projektzespolowy.util.wrappers.SaveZalacznikDTO;
import com.janusze.projektzespolowy.zalacznik.dto.ZalacznikDTO;
import com.janusze.projektzespolowy.zalacznik.ob.ZalacznikOB;
import com.janusze.projektzespolowy.zalacznik.repository.IZalacznikRepository;
import com.janusze.projektzespolowy.zalacznik.service.IZalacznikService;
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
public class ZalacznikServiceImpl implements IZalacznikService {

    @Autowired
    IZalacznikRepository iZalacznikRepository;
    @Autowired
    ZalacznikConverter zalacznikConverter;
    @Autowired
    IHistoriaService historiaService;
    @Autowired
    HistoriaConverter historiaConverter;
    @Autowired
    IBinariaService binariaService;
    @Autowired
    BinariaConverter binariaConverter;




    @Override
    public ZalacznikDTO findZalacznikById(Long aId) {
        ZalacznikOB pZalacznikOB = iZalacznikRepository.findOne(aId);
        if (pZalacznikOB == null) {
            return null;
        }
        return zalacznikConverter.mapOBtoDTO(pZalacznikOB);
    }

    @Override
    public List<ZalacznikDTO> findAllZalacznik() {
        List<ZalacznikDTO> pResult = new ArrayList<>();
        List<ZalacznikOB> pZalacznikList = iZalacznikRepository.findAll();
        for (ZalacznikOB zalacznik : pZalacznikList) {
            pResult.add(zalacznikConverter.mapOBtoDTO(zalacznik));
        }
        return pResult;
    }

    @Override
    public ZalacznikDTO saveZalacznik(SaveZalacznikDTO aWrapper) {
        ZalacznikDTO pZalacznikDTO = aWrapper.getZalacznik();
        HistoriaDTO pHistoriaDTO = aWrapper.getHistoria();
        BinariaDTO pBinariaDTO = aWrapper.getBinaria();
        if (pZalacznikDTO == null || pBinariaDTO == null || pHistoriaDTO == null) {
            return null;
        }
        ZalacznikOB pZalacznikOB = iZalacznikRepository.findOne(pZalacznikDTO.getId());
        if (pZalacznikOB == null) {
            HistoriaOB pHistoriaOB = historiaConverter.mapDTOtoOB(historiaService.findHistoriaById(pHistoriaDTO.getId()));
            BinariaOB pBinariaOB = binariaConverter.mapDTOtoOB(binariaService.findBinariaById(pBinariaDTO.getId()));
            pZalacznikOB = zalacznikConverter.mapDTOtoOB(pZalacznikDTO);
            pZalacznikOB.setHistoria(pHistoriaOB);
            pZalacznikOB.setBinaria(pBinariaOB);
            return zalacznikConverter.mapOBtoDTO(iZalacznikRepository.save(pZalacznikOB));
        }
        pZalacznikOB.setNazwa(pZalacznikDTO.getNazwa());
        pZalacznikOB.setMimeType(pZalacznikDTO.getMimeType());
        return zalacznikConverter.mapOBtoDTO(iZalacznikRepository.save(pZalacznikOB));
    }


    @Override
    public List<ZalacznikDTO> findByHistoriaId(Long aHistoriaId) {
        List<ZalacznikDTO> pResult = new ArrayList<>();
        List<ZalacznikOB> pZalacznikList = iZalacznikRepository.findByHistoriaId(aHistoriaId);
        for (ZalacznikOB zalacznik : pZalacznikList) {
            pResult.add(zalacznikConverter.mapOBtoDTO(zalacznik));
        }
        return pResult;
    }

    @Override
    public void deleteZalacznik(Long aId) {
        iZalacznikRepository.delete(aId);
    }
}
