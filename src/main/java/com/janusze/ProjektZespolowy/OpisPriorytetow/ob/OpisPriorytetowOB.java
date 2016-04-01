package com.janusze.projektzespolowy.opispriorytetow.ob;

import com.janusze.projektzespolowy.util.enums.EJednostkaCzasu;
import com.janusze.projektzespolowy.util.enums.ETypPriorytetu;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
@Data
@AllArgsConstructor
public class OpisPriorytetowOB{
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private ETypPriorytetu typ;
    private EJednostkaCzasu jednostka;
    private int ilosc;

}
