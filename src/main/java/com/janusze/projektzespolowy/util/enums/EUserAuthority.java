package com.janusze.projektzespolowy.util.enums;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Tomasz Jodko on 2016-06-01.
 */
public enum EUserAuthority implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_USER;

    public String getAuthority() {
        return name();
    }
}