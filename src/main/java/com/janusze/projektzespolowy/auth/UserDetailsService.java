package com.janusze.projektzespolowy.auth;

import com.janusze.projektzespolowy.user.dto.UserDetailsDTO;
import com.janusze.projektzespolowy.user.service.IUserService;
import com.janusze.projektzespolowy.util.converters.impl.UserDetailsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Tomasz Jodko on 2016-05-10.
 */
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserDetailsConverter userDetailsConverter;

    @Autowired
    private IUserService userService;

    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

    @Override
    public final UserDetailsDTO loadUserByUsername(String email) throws UsernameNotFoundException {
        final UserDetailsDTO pUserDTO = userDetailsConverter.mapOBtoDTO(userService.findUserByEmail(email));
        if (pUserDTO == null) {
            throw new UsernameNotFoundException("user not found");
        }
        detailsChecker.check(pUserDTO);
        return pUserDTO;
    }
}
