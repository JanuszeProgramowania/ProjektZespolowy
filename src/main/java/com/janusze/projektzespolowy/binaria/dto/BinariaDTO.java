package com.janusze.projektzespolowy.binaria.dto;

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
public class BinariaDTO implements Serializable {
    private Long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String bin;
}
