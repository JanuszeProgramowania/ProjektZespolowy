package com.janusze.projektzespolowy.user.dto;

import com.janusze.projektzespolowy.util.enums.ETypUzytkownika;
import com.janusze.projektzespolowy.util.enums.EUserAuthority;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tomasz Jodko on 2016-04-06.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class UserDTO implements Serializable {
    private Long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private boolean aktywny;
    private String email;
    private String name;
    private String lastName;
    private String password;
    private ETypUzytkownika typUzytkownika;
    private EUserAuthority authority;

}
