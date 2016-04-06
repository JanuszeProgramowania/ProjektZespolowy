package com.janusze.projektzespolowy.zgloszenie.dto;

import com.janusze.projektzespolowy.historia.ob.HistoriaOB;
import com.janusze.projektzespolowy.priorytet.ob.PriorytetOB;
import com.janusze.projektzespolowy.projekt.ob.ProjektOB;
import com.janusze.projektzespolowy.user.ob.UserOB;
import com.janusze.projektzespolowy.util.enums.EStatusZgloszenia;
import com.janusze.projektzespolowy.util.enums.ETypZgloszenia;
import com.janusze.projektzespolowy.util.enums.EZgloszenieWewZew;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-06.
 */
@Data
@AllArgsConstructor
@ApiModel
public class ZgloszenieDTO {
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String opis;
    private PriorytetOB priorytet;
    private ProjektOB projekt;
    private EStatusZgloszenia status;
    private ETypZgloszenia typZgloszenia;
    private List<HistoriaOB> historia;
    private EZgloszenieWewZew zgloszenieWewZew;
    private UserOB user;
}
