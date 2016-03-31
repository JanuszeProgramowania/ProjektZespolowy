package com.janusze.projektzespolowy.zalacznik.ob;

import com.janusze.projektzespolowy.BaseOB;
import com.janusze.projektzespolowy.user.ob.UserOB;
import com.janusze.projektzespolowy.binaria.ob.BinariaOB;

import java.util.Date;

/**
 * Created by Piotr Dordzik on 3/18/2016.
 */
public class ZalacznikOB extends BaseOB{


    private String mimeType;
    private String nazwa;
    private BinariaOB binaria;
    private UserOB user;

    public ZalacznikOB(long id, Date dataUtworzenia, Date dataModyfikacji, String nazwa, String mimeType, BinariaOB binaria, UserOB user) {
        super(id, dataUtworzenia, dataModyfikacji);
        this.nazwa = nazwa;
        this.mimeType = mimeType;
        this.binaria = binaria;
        this.user = user;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public BinariaOB getBinaria() {
        return binaria;
    }

    public void setBinaria(BinariaOB binaria) {
        this.binaria = binaria;
    }

    public UserOB getUser() {
        return user;
    }

    public void setUser(UserOB user) {
        this.user = user;
    }
}
