package com.janusze.projektzespolowy.rola.ob;

import com.janusze.projektzespolowy.BaseOB;
import com.janusze.projektzespolowy.uprawnienie.ob.UprawnienieOB;
import com.janusze.projektzespolowy.user.ob.UserOB;

import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
public class RolaOB extends BaseOB{
    private String nazwa;
    private List<UprawnienieOB> uprawnienia;
    private List<UserOB> users;


    public RolaOB(long id, Date dataUtworzenia, Date dataModyfikacji, String nazwa, List<UprawnienieOB> uprawnienia, List<UserOB> users) {
        super(id, dataUtworzenia, dataModyfikacji);
        this.nazwa = nazwa;
        this.uprawnienia = uprawnienia;
        this.users = users;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<UprawnienieOB> getUprawnienia() {
        return uprawnienia;
    }

    public void setUprawnienia(List<UprawnienieOB> uprawnienia) {
        this.uprawnienia = uprawnienia;
    }

    public List<UserOB> getUsers() {
        return users;
    }

    public void setUsers(List<UserOB> users) {
        this.users = users;
    }
}
