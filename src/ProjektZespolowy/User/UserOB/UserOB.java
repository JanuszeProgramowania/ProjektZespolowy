package ProjektZespolowy.User.UserOB;

import ProjektZespolowy.Projekt.ProjektOB.ProjektOB;
import ProjektZespolowy.User.RolaOB.RolaOB;
import ProjektZespolowy.Util.ETypUzytkownika;

import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
public class UserOB {
    private boolean aktywny;
    private String email;
    private long id;
    private String nazwa;
    private String passwordMd5;
    private List<ProjektOB> projekty;
    private List<RolaOB> role;
    private Date techDate;
    private ETypUzytkownika typUzytkownika;

//todo
    public UserOB(){

    }

    public boolean isAktywny() {
        return aktywny;
    }

    public void setAktywny(boolean aktywny) {
        this.aktywny = aktywny;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPasswordMd5() {
        return passwordMd5;
    }

    public void setPasswordMd5(String passwordMd5) {
        this.passwordMd5 = passwordMd5;
    }

    public List<ProjektOB> getProjekty() {
        return projekty;
    }

    public void setProjekty(List<ProjektOB> projekty) {
        this.projekty = projekty;
    }

    public List<RolaOB> getRole() {
        return role;
    }

    public void setRole(List<RolaOB> role) {
        this.role = role;
    }

    public Date getTechDate() {
        return techDate;
    }

    public void setTechDate(Date techDate) {
        this.techDate = techDate;
    }

    public ETypUzytkownika getTypUzytkownika() {
        return typUzytkownika;
    }

    public void setTypUzytkownika(ETypUzytkownika typUzytkownika) {
        this.typUzytkownika = typUzytkownika;
    }
}
