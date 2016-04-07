package com.janusze.projektzespolowy.util.converters.impl;

import com.janusze.projektzespolowy.rola.dto.RolaDTO;
import com.janusze.projektzespolowy.rola.ob.RolaOB;
import com.janusze.projektzespolowy.util.converters.AbstractConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Component
public class RolaConverter extends AbstractConverter<RolaOB, RolaDTO> {
    @Autowired
    public RolaConverter(Mapper mapper) {
        super(mapper, RolaOB.class, RolaDTO.class);
    }
}