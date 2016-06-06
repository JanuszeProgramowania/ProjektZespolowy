package com.janusze.projektzespolowy.projekt.dto;

import com.janusze.projektzespolowy.company.dto.CompanyDTO;
import com.janusze.projektzespolowy.user.dto.UserDTO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Tomasz Jodko on 2016-04-06.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class ProjektDTO implements Serializable {
    private Long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String nazwa;
    private String opis;
    private String wersja;
    private Set<UserDTO> users;
    private Set<CompanyDTO> companies;


}
