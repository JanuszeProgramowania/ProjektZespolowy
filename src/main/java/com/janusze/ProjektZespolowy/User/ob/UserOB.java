package com.janusze.projektzespolowy.user.ob;

import com.janusze.projektzespolowy.projekt.ob.ProjektOB;
import com.janusze.projektzespolowy.rola.ob.RolaOB;
import com.janusze.projektzespolowy.util.enums.ETypUzytkownika;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
@Data
@AllArgsConstructor
public class UserOB{
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private boolean aktywny;
    private String email;
    private String nazwa;
    private String passwordMd5;
    private List<ProjektOB> projekty;
    private List<RolaOB> role;
    private ETypUzytkownika typUzytkownika;

}
