package com.janusze.projektzespolowy.auth;

import com.janusze.projektzespolowy.user.dto.UserDetailsDTO;
import com.janusze.projektzespolowy.util.enums.EUserAuthority;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tomasz Jodko on 2016-05-10.
 */
public class UserAuthentication implements Authentication {

    private final UserDetailsDTO userDTO;
    private boolean authenticated = true;

    public UserAuthentication(UserDetailsDTO user) {
        this.userDTO = user;
    }

    @Override
    public String getName() {
        return userDTO.getEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<EUserAuthority> singleKurwaAuthority = new HashSet<>();
        singleKurwaAuthority.add(userDTO.getAuthority());
        return singleKurwaAuthority;
    }


    @Override
    public Object getCredentials() {
        return userDTO.getPassword();
    }

    @Override
    public UserDetailsDTO getDetails() {
        return new UserDetailsDTO(userDTO.getId(),userDTO.getName(),userDTO.getLastName(),userDTO.getEmail(),userDTO.getAuthority(),userDTO.isAktywny(),userDTO.getDataUtworzenia(),userDTO.getTypUzytkownika(),userDTO.getCompany());
    }

    @Override
    public Object getPrincipal() {
        return userDTO.getEmail();
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
