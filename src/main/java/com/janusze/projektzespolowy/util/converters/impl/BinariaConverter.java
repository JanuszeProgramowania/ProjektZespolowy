package com.janusze.projektzespolowy.util.converters.impl;

import com.janusze.projektzespolowy.binaria.dto.BinariaDTO;
import com.janusze.projektzespolowy.binaria.ob.BinariaOB;
import com.janusze.projektzespolowy.util.converters.AbstractConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Component
public class BinariaConverter extends AbstractConverter<BinariaOB, BinariaDTO> {
    @Autowired
    public BinariaConverter(Mapper mapper) {
        super(mapper, BinariaOB.class, BinariaDTO.class);
    }
}
