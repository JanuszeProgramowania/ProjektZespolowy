package com.janusze.projektzespolowy.projekt.ob;

import com.janusze.projektzespolowy.opispriorytetow.ob.OpisPriorytetowOB;
import com.janusze.projektzespolowy.user.ob.UserOB;
import com.janusze.projektzespolowy.zgloszenie.ob.ZgloszenieOB;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
@Data
@AllArgsConstructor
public class ProjektOB{
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String nazwa;
    private String opis;
    private String wersja;
    private List<UserOB> users;
    private List<OpisPriorytetowOB> opisPriorytetow;
    private List<ZgloszenieOB> zgloszenia;

}
