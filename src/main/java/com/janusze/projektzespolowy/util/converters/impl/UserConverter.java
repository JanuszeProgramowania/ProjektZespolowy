package com.janusze.projektzespolowy.util.converters.impl;

import com.janusze.projektzespolowy.user.dto.UserDTO;
import com.janusze.projektzespolowy.user.ob.UserOB;
import com.janusze.projektzespolowy.util.converters.AbstractConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Component
public class UserConverter extends AbstractConverter<UserOB, UserDTO> {
    @Autowired
    public UserConverter(Mapper mapper) {
        super(mapper, UserOB.class, UserDTO.class);
    }
}
