package com.janusze.projektzespolowy.util.converters.impl;

import com.janusze.projektzespolowy.user.dto.UserDTO;
import com.janusze.projektzespolowy.user.dto.UserDetailsDTO;
import com.janusze.projektzespolowy.util.converters.AbstractConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Tomasz Jodko on 2016-06-01.
 */
@Component
public class UserDetailsConverter extends AbstractConverter<UserDTO, UserDetailsDTO> {
    @Autowired
    public UserDetailsConverter(Mapper mapper) {
        super(mapper, UserDTO.class, UserDetailsDTO.class);
    }
}
