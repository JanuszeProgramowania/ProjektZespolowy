package com.janusze.projektzespolowy.historia.ob;

import com.janusze.projektzespolowy.user.ob.UserOB;
import com.janusze.projektzespolowy.util.enums.ETypKomentarza;
import com.janusze.projektzespolowy.zalacznik.ob.ZalacznikOB;
import com.janusze.projektzespolowy.zgloszenie.ob.ZgloszenieOB;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Piotr Dordzik on 3/18/2016.
 */
@Data
@AllArgsConstructor
public class HistoriaOB{
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String opis;
    private ETypKomentarza typ;
    private List<ZalacznikOB> zalaczniki;
    private ZgloszenieOB zgloszenie;
    private UserOB user;

}
