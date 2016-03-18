package ProjektZespolowy.User.RolaOB;

import ProjektZespolowy.User.UprawnienieOB.UprawnienieOB;

import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
public class RolaOB {
    private long id;
    private String nazwa;
    private List<UprawnienieOB> uprawnienia;

    public RolaOB(long id, String nazwa, List<UprawnienieOB> uprawnienia) {
        this.id = id;
        this.nazwa = nazwa;
        this.uprawnienia = uprawnienia;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
