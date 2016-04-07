package com.janusze.projektzespolowy.util.converters.impl;

import com.janusze.projektzespolowy.uprawnienie.dto.UprawnienieDTO;
import com.janusze.projektzespolowy.uprawnienie.ob.UprawnienieOB;
import com.janusze.projektzespolowy.util.converters.AbstractConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Component
public class UprawnienieConverter extends AbstractConverter<UprawnienieOB, UprawnienieDTO> {
    @Autowired
    public UprawnienieConverter(Mapper mapper) {
        super(mapper, UprawnienieOB.class, UprawnienieDTO.class);
    }
}