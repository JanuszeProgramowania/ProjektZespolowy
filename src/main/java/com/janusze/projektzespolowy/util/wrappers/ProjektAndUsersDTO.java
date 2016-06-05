package com.janusze.projektzespolowy.util.wrappers;

import com.janusze.projektzespolowy.projekt.dto.ProjektDTO;
import com.janusze.projektzespolowy.user.dto.UserDTO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by Tomasz Jodko on 2016-06-06.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class ProjektAndUsersDTO {
    private ProjektDTO projekt;
    private Set<UserDTO> users;
}

