package com.janusze.projektzespolowy.rola.dto;

import com.janusze.projektzespolowy.uprawnienie.ob.UprawnienieOB;
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
public class RolaDTO {
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String nazwa;
    private List<UprawnienieOB> uprawnienia;
}
