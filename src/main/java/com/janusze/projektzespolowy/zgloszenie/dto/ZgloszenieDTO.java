package com.janusze.projektzespolowy.zgloszenie.dto;

import com.janusze.projektzespolowy.priorytet.dto.PriorytetDTO;
import com.janusze.projektzespolowy.projekt.dto.ProjektDTO;
import com.janusze.projektzespolowy.user.dto.UserDTO;
import com.janusze.projektzespolowy.util.enums.EStatusZgloszenia;
import com.janusze.projektzespolowy.util.enums.ETypZgloszenia;
import com.janusze.projektzespolowy.util.enums.EZgloszenieWewZew;
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
public class ZgloszenieDTO implements Serializable {
    private Long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String title;
    private String opis;
    private PriorytetDTO priorytet;
    private ProjektDTO projekt;
    private EStatusZgloszenia status;
    private ETypZgloszenia typZgloszenia;
    private EZgloszenieWewZew zgloszenieWewZew;
    private UserDTO user;
}
