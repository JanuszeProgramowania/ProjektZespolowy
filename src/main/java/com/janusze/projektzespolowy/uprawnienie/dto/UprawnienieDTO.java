package com.janusze.projektzespolowy.uprawnienie.dto;

import com.janusze.projektzespolowy.rola.ob.RolaOB;
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
public class UprawnienieDTO {
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String nazwa;
    private RolaOB rola;
}
