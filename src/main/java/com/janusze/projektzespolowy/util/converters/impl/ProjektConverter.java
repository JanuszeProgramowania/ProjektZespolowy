package com.janusze.projektzespolowy.util.converters.impl;

import com.janusze.projektzespolowy.projekt.dto.ProjektDTO;
import com.janusze.projektzespolowy.projekt.ob.ProjektOB;
import com.janusze.projektzespolowy.util.converters.AbstractConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Component
public class ProjektConverter extends AbstractConverter<ProjektOB, ProjektDTO> {
    @Autowired
    public ProjektConverter(Mapper mapper) {
        super(mapper, ProjektOB.class, ProjektDTO.class);
    }
}