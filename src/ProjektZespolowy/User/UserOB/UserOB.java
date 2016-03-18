package ProjektZespolowy.User.UserOB;

import ProjektZespolowy.BaseOB.BaseOB;
import ProjektZespolowy.Projekt.ProjektOB.ProjektOB;
import ProjektZespolowy.User.RolaOB.RolaOB;
import ProjektZespolowy.Util.ETypUzytkownika;

import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
public class UserOB extends BaseOB {
    private boolean aktywny;
    private String email;
    private String nazwa;
    private String passwordMd5;
    private List<ProjektOB> projekty;
    private List<RolaOB> role;
    private ETypUzytkownika typUzytkownika;

    public UserOB(long id, Date dataUtworzenia, Date dataModyfikacji, boolean aktywny, String email, String nazwa, String passwordMd5, List<ProjektOB> projekty, List<RolaOB> role, ETypUzytkownika typUzytkownika) {
        super(id, dataUtworzenia, dataModyfikacji);
        this.aktywny = aktywny;
        this.email = email;
        this.nazwa = nazwa;
        this.passwordMd5 = passwordMd5;
        this.projekty = projekty;
        this.role = role;
        this.typUzytkownika = typUzytkownika;
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

    public ETypUzytkownika getTypUzytkownika() {
        return typUzytkownika;
    }

    public void setTypUzytkownika(ETypUzytkownika typUzytkownika) {
        this.typUzytkownika = typUzytkownika;
    }
}
