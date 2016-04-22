package com.janusze.projektzespolowy.util.wrappers;

import com.janusze.projektzespolowy.historia.dto.HistoriaDTO;
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
public class SaveHistoriaDTO {
    private HistoriaDTO historia;
    private UserDTO user;
    private ZgloszenieDTO zgloszenie;
}
