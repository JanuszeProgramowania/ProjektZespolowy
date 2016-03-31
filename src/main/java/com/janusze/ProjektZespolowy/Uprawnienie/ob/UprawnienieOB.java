package com.janusze.projektzespolowy.uprawnienie.ob;

import com.janusze.projektzespolowy.BaseOB;
import com.janusze.projektzespolowy.rola.ob.RolaOB;

import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
public class UprawnienieOB extends BaseOB {
    private String nazwa;
    private List<RolaOB> role;

    public UprawnienieOB(long id, Date dataUtworzenia, Date dataModyfikacji, String nazwa, List<RolaOB> role) {
        super(id, dataUtworzenia, dataModyfikacji);
        this.nazwa = nazwa;
        this.role = role;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<RolaOB> getRole() {
        return role;
    }

    public void setRole(List<RolaOB> role) {
        this.role = role;
    }
}
