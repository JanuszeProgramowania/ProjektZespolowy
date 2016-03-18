package ProjektZespolowy.Zgloszenie.KomentarzOB;

import ProjektZespolowy.Util.ETypKomentarza;

import java.util.Date;

/**
 * Created by Piotr Dordzik on 3/18/2016.
 */
public class KomentarzOB {

    private long id;
    private long idZgloszenia;
    private long idZgloszeniaWewnetrznego;
    private String opis;
    private Date techDate;
    private ETypKomentarza typ;
    private long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdZgloszenia() {
        return idZgloszenia;
    }

    public void setIdZgloszenia(long idZgloszenia) {
        this.idZgloszenia = idZgloszenia;
    }

    public long getIdZgloszeniaWewnetrznego() {
        return idZgloszeniaWewnetrznego;
    }

    public void setIdZgloszeniaWewnetrznego(long idZgloszeniaWewnetrznego) {
        this.idZgloszeniaWewnetrznego = idZgloszeniaWewnetrznego;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getTechDate() {
        return techDate;
    }

    public void setTechDate(Date techDate) {
        this.techDate = techDate;
    }

    public ETypKomentarza getTyp() {
        return typ;
    }

    public void setTyp(ETypKomentarza typ) {
        this.typ = typ;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public KomentarzOB()
    {

    }
}
