package com.janusze.projektzespolowy.historia.dto;

import com.janusze.projektzespolowy.user.dto.UserDTO;
import com.janusze.projektzespolowy.util.enums.ETypKomentarza;
import com.janusze.projektzespolowy.zgloszenie.dto.ZgloszenieDTO;
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
public class HistoriaDTO implements Serializable {
    private Long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String opis;
    private ETypKomentarza typ;
    private ZgloszenieDTO zgloszenie;
    private UserDTO user;
}
