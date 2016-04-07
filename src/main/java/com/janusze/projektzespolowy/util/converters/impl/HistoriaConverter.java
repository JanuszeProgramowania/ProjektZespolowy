package com.janusze.projektzespolowy.util.converters.impl;

import com.janusze.projektzespolowy.historia.dto.HistoriaDTO;
import com.janusze.projektzespolowy.historia.ob.HistoriaOB;
import com.janusze.projektzespolowy.util.converters.AbstractConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Component
public class HistoriaConverter extends AbstractConverter<HistoriaOB, HistoriaDTO> {
    @Autowired
    public HistoriaConverter(Mapper mapper) {
        super(mapper, HistoriaOB.class, HistoriaDTO.class);
    }
}