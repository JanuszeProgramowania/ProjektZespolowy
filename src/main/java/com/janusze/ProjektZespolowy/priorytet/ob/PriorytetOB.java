package com.janusze.projektzespolowy.priorytet.ob;

import com.janusze.projektzespolowy.BaseOB;
import com.janusze.projektzespolowy.util.enums.ETypPriorytetu;

import java.util.Date;

/**
 * Created by Piotr Dordzik on 3/18/2016.
 */
public class PriorytetOB extends BaseOB {

    private ETypPriorytetu typ;

    public PriorytetOB(long id, Date dataUtworzenia, Date dataModyfikacji, ETypPriorytetu typ) {
        super(id, dataUtworzenia, dataModyfikacji);
        this.typ = typ;
    }

    public ETypPriorytetu getTyp() {
        return typ;
    }

    public void setTyp(ETypPriorytetu typ) {
        this.typ = typ;
    }
}
