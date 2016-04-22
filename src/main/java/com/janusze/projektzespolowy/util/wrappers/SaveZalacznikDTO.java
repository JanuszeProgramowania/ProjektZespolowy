package com.janusze.projektzespolowy.util.wrappers;

import com.janusze.projektzespolowy.binaria.dto.BinariaDTO;
import com.janusze.projektzespolowy.historia.dto.HistoriaDTO;
import com.janusze.projektzespolowy.zalacznik.dto.ZalacznikDTO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Tomasz Jodko on 2016-04-22.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class SaveZalacznikDTO {
    private ZalacznikDTO zalacznik;
    private BinariaDTO binaria;
    private HistoriaDTO historia;
}
