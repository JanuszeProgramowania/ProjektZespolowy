package com.janusze.projektzespolowy.rola.dto;

import com.janusze.projektzespolowy.uprawnienie.dto.UprawnienieDTO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-06.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class RolaDTO implements Serializable {
    private Long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String nazwa;
    private List<UprawnienieDTO> uprawnienia;
}
