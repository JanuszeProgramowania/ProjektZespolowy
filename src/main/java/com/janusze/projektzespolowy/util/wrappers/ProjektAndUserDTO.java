package com.janusze.projektzespolowy.util.wrappers;

import com.janusze.projektzespolowy.projekt.dto.ProjektDTO;
import com.janusze.projektzespolowy.user.dto.UserDTO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Tomasz Jodko on 2016-04-21.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class ProjektAndUserDTO {
    private ProjektDTO projekt;
    private UserDTO user;
}
