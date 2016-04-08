package com.janusze.projektzespolowy.uprawnienie.dto;

import com.janusze.projektzespolowy.rola.dto.RolaDTO;
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
public class UprawnienieDTO implements Serializable {
    private Long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String nazwa;
    private RolaDTO rola;
}
