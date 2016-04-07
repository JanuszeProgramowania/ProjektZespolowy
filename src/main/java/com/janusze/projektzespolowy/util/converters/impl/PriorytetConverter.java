package com.janusze.projektzespolowy.util.converters.impl;

import com.janusze.projektzespolowy.priorytet.dto.PriorytetDTO;
import com.janusze.projektzespolowy.priorytet.ob.PriorytetOB;
import com.janusze.projektzespolowy.util.converters.AbstractConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Component
public class PriorytetConverter extends AbstractConverter<PriorytetOB, PriorytetDTO> {
    @Autowired
    public PriorytetConverter(Mapper mapper) {
        super(mapper, PriorytetOB.class, PriorytetDTO.class);
    }
}