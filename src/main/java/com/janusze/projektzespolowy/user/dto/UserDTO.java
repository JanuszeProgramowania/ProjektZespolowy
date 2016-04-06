package com.janusze.projektzespolowy.user.dto;

import com.janusze.projektzespolowy.historia.ob.HistoriaOB;
import com.janusze.projektzespolowy.projekt.ob.ProjektOB;
import com.janusze.projektzespolowy.rola.ob.RolaOB;
import com.janusze.projektzespolowy.util.enums.ETypUzytkownika;
import com.janusze.projektzespolowy.zgloszenie.ob.ZgloszenieOB;
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
public class UserDTO {
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private boolean aktywny;
    private String email;
    private String imie;
    private String nazwisko;
    private String passwordMd5;
    private List<ProjektOB> projekty;
    private List<RolaOB> role;
    private ETypUzytkownika typUzytkownika;
    private List<ZgloszenieOB> zgloszenia;
    private List<HistoriaOB> historia;

}
