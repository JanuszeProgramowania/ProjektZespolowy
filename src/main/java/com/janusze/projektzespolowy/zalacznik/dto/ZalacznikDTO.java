package com.janusze.projektzespolowy.zalacznik.dto;

import com.janusze.projektzespolowy.binaria.ob.BinariaOB;
import com.janusze.projektzespolowy.historia.ob.HistoriaOB;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Created by Tomasz Jodko on 2016-04-06.
 */
@Data
@AllArgsConstructor
@ApiModel
public class ZalacznikDTO {
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String mimeType;
    private String nazwa;
    private BinariaOB binaria;
    private HistoriaOB historia;
}
