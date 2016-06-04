package com.janusze.projektzespolowy.util.converters.impl;

import com.janusze.projektzespolowy.company.dto.CompanyDTO;
import com.janusze.projektzespolowy.company.ob.CompanyOB;
import com.janusze.projektzespolowy.util.converters.AbstractConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tomasz Jodko on 2016-06-04.
 */
@Component
public class CompanyConverter extends AbstractConverter<CompanyOB, CompanyDTO> {
    @Autowired
    public CompanyConverter(Mapper mapper) {
        super(mapper, CompanyOB.class, CompanyDTO.class);
    }
}