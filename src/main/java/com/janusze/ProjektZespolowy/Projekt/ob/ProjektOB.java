package com.janusze.projektzespolowy.projekt.ob;

import com.janusze.projektzespolowy.BaseOB;
import com.janusze.projektzespolowy.opispriorytetow.ob.OpisPriorytetowOB;
import com.janusze.projektzespolowy.user.ob.UserOB;
import com.janusze.projektzespolowy.zgloszenie.ob.ZgloszenieOB;

import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-03-18.

 */
public class ProjektOB extends BaseOB {
    private String nazwa;
    private String opis;
    private String wersja;
    private List<UserOB> users;
    private List<OpisPriorytetowOB> opisPriorytetow;
    private List<ZgloszenieOB> zgloszenia;


    public ProjektOB(long id, Date dataUtworzenia, Date dataModyfikacji, String nazwa, String opis, String wersja, List<UserOB> users, List<OpisPriorytetowOB> opisPriorytetow, List<ZgloszenieOB> zgloszenia) {
        super(id, dataUtworzenia, dataModyfikacji);
        this.nazwa = nazwa;
        this.opis = opis;
        this.wersja = wersja;
        this.users = users;
        this.opisPriorytetow = opisPriorytetow;
        this.zgloszenia = zgloszenia;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getWersja() {
        return wersja;
    }

    public void setWersja(String wersja) {
        this.wersja = wersja;
    }

    public List<UserOB> getUsers() {
        return users;
    }

    public void setUsers(List<UserOB> users) {
        this.users = users;
    }

    public List<OpisPriorytetowOB> getOpisPriorytetow() {
        return opisPriorytetow;
    }

    public void setOpisPriorytetow(List<OpisPriorytetowOB> opisPriorytetow) {
        this.opisPriorytetow = opisPriorytetow;
    }

    public List<ZgloszenieOB> getZgloszenia() {
        return zgloszenia;
    }

    public void setZgloszenia(List<ZgloszenieOB> zgloszenia) {
        this.zgloszenia = zgloszenia;
    }
}
