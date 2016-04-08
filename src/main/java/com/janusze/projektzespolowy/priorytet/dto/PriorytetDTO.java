package com.janusze.projektzespolowy.priorytet.dto;

import com.janusze.projektzespolowy.util.enums.EJednostkaCzasu;
import com.janusze.projektzespolowy.util.enums.ETypPriorytetu;
import com.janusze.projektzespolowy.zgloszenie.dto.ZgloszenieDTO;
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
public class PriorytetDTO implements Serializable {
    private Long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private ETypPriorytetu typ;
    private EJednostkaCzasu jednostka;
    private int ilosc;
    private List<ZgloszenieDTO> zgloszenia;
}
