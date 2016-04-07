package com.janusze.projektzespolowy.util.converters.impl;

import com.janusze.projektzespolowy.util.converters.AbstractConverter;
import com.janusze.projektzespolowy.zgloszenie.dto.ZgloszenieDTO;
import com.janusze.projektzespolowy.zgloszenie.ob.ZgloszenieOB;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Component
public class ZgloszenieConverter extends AbstractConverter<ZgloszenieOB, ZgloszenieDTO> {
    @Autowired
    public ZgloszenieConverter(Mapper mapper) {
        super(mapper, ZgloszenieOB.class, ZgloszenieDTO.class);
    }
}