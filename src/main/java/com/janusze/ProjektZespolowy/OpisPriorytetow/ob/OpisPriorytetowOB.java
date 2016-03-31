package com.janusze.projektzespolowy.opispriorytetow.ob;

import com.janusze.projektzespolowy.BaseOB;
import com.janusze.projektzespolowy.util.enums.EJednostkaCzasu;
import com.janusze.projektzespolowy.util.enums.ETypPriorytetu;

import java.util.Date;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
public class OpisPriorytetowOB extends BaseOB{
    private ETypPriorytetu typ;
    private EJednostkaCzasu jednostka;
    private int ilosc;

    public OpisPriorytetowOB(long id, Date dataUtworzenia, Date dataModyfikacji, ETypPriorytetu typ, EJednostkaCzasu jednostka, int ilosc) {
        super(id, dataUtworzenia, dataModyfikacji);
        this.typ = typ;
        this.jednostka = jednostka;
        this.ilosc = ilosc;
    }

    public ETypPriorytetu getTyp() {
        return typ;
    }

    public void setTyp(ETypPriorytetu typ) {
        this.typ = typ;
    }

    public EJednostkaCzasu getJednostka() {
        return jednostka;
    }

    public void setJednostka(EJednostkaCzasu jednostka) {
        this.jednostka = jednostka;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}
