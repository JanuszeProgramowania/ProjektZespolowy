package com.janusze.projektzespolowy.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.janusze.projektzespolowy.util.enums.ETypUzytkownika;
import com.janusze.projektzespolowy.util.enums.EUserAuthority;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tomasz Jodko on 2016-06-01.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class UserDetailsDTO implements UserDetails,Serializable {
    private Long id;
    private Date dataUtworzenia;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Date dataModyfikacji;
    private boolean aktywny;
    private String email;
    private String name;
    private String lastName;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String password;
    private long expires;
    private ETypUzytkownika typUzytkownika;
    private EUserAuthority authority;

    public UserDetailsDTO(Long id, String name, String lastName, String email, EUserAuthority authority, boolean aktywny, Date dataUtworzenia, ETypUzytkownika typUzytkownika) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.authority = authority;
        this.aktywny = aktywny;
        this.dataUtworzenia = dataUtworzenia;
        this.typUzytkownika = typUzytkownika;
    }


    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<EUserAuthority> auth = new HashSet<>();
        auth.add(authority);
        if (authority == EUserAuthority.ROLE_ADMIN) {
            auth.add(EUserAuthority.ROLE_USER);
        }
        return auth;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return this.email;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
