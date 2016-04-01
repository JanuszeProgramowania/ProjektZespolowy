package com.janusze.projektzespolowy.zgloszenie.ob;

import com.janusze.projektzespolowy.historia.ob.HistoriaOB;
import com.janusze.projektzespolowy.priorytet.ob.PriorytetOB;
import com.janusze.projektzespolowy.projekt.ob.ProjektOB;
import com.janusze.projektzespolowy.util.enums.EStatusZgloszenia;
import com.janusze.projektzespolowy.util.enums.ETypZgloszenia;
import com.janusze.projektzespolowy.util.enums.EZgloszenieWewZew;
import com.janusze.projektzespolowy.zalacznik.ob.ZalacznikOB;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by Piotr Dordzik on 3/18/2016.
 */
@Data
@AllArgsConstructor
public class ZgloszenieOB{

    private String opis;
    private PriorytetOB priorytet;
    private ProjektOB projekt;
    private EStatusZgloszenia status;
    private ETypZgloszenia typZgloszenia;
    private List<HistoriaOB> historia;
    private List<ZalacznikOB> zalaczniki;
    private EZgloszenieWewZew zgloszenieWewZew;

}
