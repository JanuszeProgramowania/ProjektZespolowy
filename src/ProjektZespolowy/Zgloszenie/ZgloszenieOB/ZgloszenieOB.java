package ProjektZespolowy.Zgloszenie.ZgloszenieOB;

import ProjektZespolowy.Util.EStatusZgloszenia;
import ProjektZespolowy.Util.ETypZgloszenia;
import ProjektZespolowy.Zgloszenie.PriorytetOB.PriorytetOB;

import java.util.Date;

/**
 * Created by Piotr Dordzik on 3/18/2016.
 */
public class ZgloszenieOB {

    private long id;
    private String opis;
    private PriorytetOB priorytet;
    //private ProjektOB projekt;
    private EStatusZgloszenia status;
    private Date techDate;
    private ETypZgloszenia typZgloszenia;

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

    public PriorytetOB getPriorytet() {
        return priorytet;
    }

    public void setPriorytet(PriorytetOB priorytet) {
        this.priorytet = priorytet;
    }

    public EStatusZgloszenia getStatus() {
        return status;
    }

    public void setStatus(EStatusZgloszenia status) {
        this.status = status;
    }

    public Date getTechDate() {
        return techDate;
    }

    public void setTechDate(Date techDate) {
        this.techDate = techDate;
    }

    public ETypZgloszenia getTypZgloszenia() {
        return typZgloszenia;
    }

    public void setTypZgloszenia(ETypZgloszenia typZgloszenia) {
        this.typZgloszenia = typZgloszenia;
    }

    public ZgloszenieOB()
    {

    }

}
