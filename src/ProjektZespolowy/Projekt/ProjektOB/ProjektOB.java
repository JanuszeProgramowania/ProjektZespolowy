package ProjektZespolowy.Projekt.ProjektOB;

import java.util.Date;

/**
 * Created by Tomasz Jodko on 2016-03-18.

 */
public class ProjektOB {
    private Date dataUtworzenia;
    private long id;
    private String nazwa;
    private String opis;
    private String wersja;


    public ProjektOB(Date dataUtworzenia, long id, String nazwa, String opis, String wersja) {
        this.dataUtworzenia = dataUtworzenia;
        this.id = id;
        this.nazwa = nazwa;
        this.opis = opis;
        this.wersja = wersja;
    }

    public Date getDataUtworzenia() {

        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
