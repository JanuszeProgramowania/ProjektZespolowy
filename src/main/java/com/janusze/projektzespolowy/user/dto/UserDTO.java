package com.janusze.projektzespolowy.user.dto;

import com.janusze.projektzespolowy.historia.dto.HistoriaDTO;
import com.janusze.projektzespolowy.projekt.dto.ProjektDTO;
import com.janusze.projektzespolowy.rola.dto.RolaDTO;
import com.janusze.projektzespolowy.util.enums.ETypUzytkownika;
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
public class UserDTO implements Serializable {
    private Long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private boolean aktywny;
    private String email;
    private String imie;
    private String nazwisko;
    private String passwordMd5;
    private List<ProjektDTO> projekty;
    private List<RolaDTO> role;
    private ETypUzytkownika typUzytkownika;
    private List<ZgloszenieDTO> zgloszenia;
    private List<HistoriaDTO> historia;

}
