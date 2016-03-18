package ProjektZespolowy.Zgloszenie.ZgloszenieOB;

import ProjektZespolowy.BaseOB.BaseOB;
import ProjektZespolowy.Projekt.ProjektOB.ProjektOB;
import ProjektZespolowy.Util.EStatusZgloszenia;
import ProjektZespolowy.Util.ETypZgloszenia;
import ProjektZespolowy.Util.EZgloszenieWewZew;
import ProjektZespolowy.Zalacznik.ZalacznikOB.ZalacznikOB;
import ProjektZespolowy.Zgloszenie.HistoriaOB.HistoriaOB;
import ProjektZespolowy.Zgloszenie.PriorytetOB.PriorytetOB;

import java.util.Date;
import java.util.List;

/**
 * Created by Piotr Dordzik on 3/18/2016.
 */
public class ZgloszenieOB extends BaseOB {

    private String opis;
    private PriorytetOB priorytet;
    private ProjektOB projekt;
    private EStatusZgloszenia status;
    private ETypZgloszenia typZgloszenia;
    private List<HistoriaOB> historia;
    private List<ZalacznikOB> zalaczniki;
    private EZgloszenieWewZew zgloszenieWewZew;


    public ZgloszenieOB(long id, Date dataUtworzenia, Date dataModyfikacji, String opis, PriorytetOB priorytet, ProjektOB projekt, EStatusZgloszenia status, ETypZgloszenia typZgloszenia, List<HistoriaOB> historia, List<ZalacznikOB> zalaczniki, EZgloszenieWewZew zgloszenieWewZew) {
        super(id, dataUtworzenia, dataModyfikacji);
        this.opis = opis;
        this.priorytet = priorytet;
        this.projekt = projekt;
        this.status = status;
        this.typZgloszenia = typZgloszenia;
        this.historia = historia;
        this.zalaczniki = zalaczniki;
        this.zgloszenieWewZew = zgloszenieWewZew;
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

    public ETypZgloszenia getTypZgloszenia() {
        return typZgloszenia;
    }

    public void setTypZgloszenia(ETypZgloszenia typZgloszenia) {
        this.typZgloszenia = typZgloszenia;
    }

    public ProjektOB getProjekt() {
        return projekt;
    }

    public void setProjekt(ProjektOB projekt) {
        this.projekt = projekt;
    }

    public List<HistoriaOB> getHistoria() {
        return historia;
    }

    public void setHistoria(List<HistoriaOB> historia) {
        this.historia = historia;
    }

    public List<ZalacznikOB> getZalaczniki() {
        return zalaczniki;
    }

    public void setZalaczniki(List<ZalacznikOB> zalaczniki) {
        this.zalaczniki = zalaczniki;
    }

    public EZgloszenieWewZew getZgloszenieWewZew() {
        return zgloszenieWewZew;
    }

    public void setZgloszenieWewZew(EZgloszenieWewZew zgloszenieWewZew) {
        this.zgloszenieWewZew = zgloszenieWewZew;
    }
}
