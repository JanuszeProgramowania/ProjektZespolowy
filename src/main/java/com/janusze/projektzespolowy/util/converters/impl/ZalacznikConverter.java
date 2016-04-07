package com.janusze.projektzespolowy.util.converters.impl;

import com.janusze.projektzespolowy.util.converters.AbstractConverter;
import com.janusze.projektzespolowy.zalacznik.dto.ZalacznikDTO;
import com.janusze.projektzespolowy.zalacznik.ob.ZalacznikOB;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Component
public class ZalacznikConverter extends AbstractConverter<ZalacznikOB, ZalacznikDTO> {
    @Autowired
    public ZalacznikConverter(Mapper mapper) {
        super(mapper, ZalacznikOB.class, ZalacznikDTO.class);
    }
}