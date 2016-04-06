package com.janusze.projektzespolowy.historia.dto;

import com.janusze.projektzespolowy.user.ob.UserOB;
import com.janusze.projektzespolowy.util.enums.ETypKomentarza;
import com.janusze.projektzespolowy.zalacznik.ob.ZalacznikOB;
import com.janusze.projektzespolowy.zgloszenie.ob.ZgloszenieOB;
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
public class HistoriaDTO {
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String opis;
    private ETypKomentarza typ;
    private List<ZalacznikOB> zalaczniki;
    private ZgloszenieOB zgloszenie;
    private UserOB user;
}
