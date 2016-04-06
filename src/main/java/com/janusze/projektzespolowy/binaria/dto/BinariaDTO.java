package com.janusze.projektzespolowy.binaria.dto;

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
public class BinariaDTO {
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private Byte[] bin;
}
