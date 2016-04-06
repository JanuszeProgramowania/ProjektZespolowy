package com.janusze.projektzespolowy.projekt.dto;

import com.janusze.projektzespolowy.user.ob.UserOB;
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
public class ProjektDTO {
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String nazwa;
    private String opis;
    private String wersja;
    private List<UserOB> users;
    private List<ZgloszenieOB> zgloszenia;

}
