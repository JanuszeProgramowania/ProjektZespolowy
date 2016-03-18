package ProjektZespolowy.Zgloszenie.ZgloszenieWewnetrzneOB;

import ProjektZespolowy.Util.EStatusZgloszenia;
import ProjektZespolowy.Util.ETypZgloszenia;
import ProjektZespolowy.Zgloszenie.PriorytetOB.PriorytetOB;

/**
 * Created by Piotr Dordzik on 3/18/2016.
 */
public class ZgloszenieWewnetrzneOB {

    private long id;
    private long idZgloszenia;
    private String opis;
    private PriorytetOB priorytet;
    private EStatusZgloszenia status;
    private ETypZgloszenia typ;

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

    public ETypZgloszenia getTyp() {
        return typ;
    }

    public void setTyp(ETypZgloszenia typ) {
        this.typ = typ;
    }

    public ZgloszenieWewnetrzneOB()
    {

    }
}
