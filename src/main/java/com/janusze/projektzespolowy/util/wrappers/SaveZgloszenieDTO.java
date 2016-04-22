package com.janusze.projektzespolowy.util.wrappers;

import com.janusze.projektzespolowy.priorytet.dto.PriorytetDTO;
import com.janusze.projektzespolowy.projekt.dto.ProjektDTO;
import com.janusze.projektzespolowy.user.dto.UserDTO;
import com.janusze.projektzespolowy.zgloszenie.dto.ZgloszenieDTO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Tomasz Jodko on 2016-04-22.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class SaveZgloszenieDTO {
    private UserDTO user;
    private ZgloszenieDTO zgloszenie;
    private PriorytetDTO priorytet;
    private ProjektDTO projekt;
}
