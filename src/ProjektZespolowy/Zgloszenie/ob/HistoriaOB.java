package ProjektZespolowy.Zgloszenie.ob;

import ProjektZespolowy.BaseOB;
import ProjektZespolowy.User.ob.UserOB;
import ProjektZespolowy.Util.enums.ETypKomentarza;
import ProjektZespolowy.Zalacznik.ob.ZalacznikOB;

import java.util.Date;
import java.util.List;

/**
 * Created by Piotr Dordzik on 3/18/2016.
 */
public class HistoriaOB extends BaseOB {

    private String opis;
    private ETypKomentarza typ;
    private List<ZalacznikOB> zalaczniki;
    private ZgloszenieOB zgloszenie;
    private UserOB user;

    public HistoriaOB(long id, Date dataUtworzenia, Date dataModyfikacji, String opis, ETypKomentarza typ, List<ZalacznikOB> zalaczniki, ZgloszenieOB zgloszenie, UserOB user) {
        super(id, dataUtworzenia, dataModyfikacji);
        this.opis = opis;
        this.typ = typ;
        this.zalaczniki = zalaczniki;
        this.zgloszenie = zgloszenie;
        this.user = user;
    }


    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public ETypKomentarza getTyp() {
        return typ;
    }

    public void setTyp(ETypKomentarza typ) {
        this.typ = typ;
    }

    public List<ZalacznikOB> getZalaczniki() {
        return zalaczniki;
    }

    public void setZalaczniki(List<ZalacznikOB> zalaczniki) {
        this.zalaczniki = zalaczniki;
    }

    public ZgloszenieOB getZgloszenie() {
        return zgloszenie;
    }

    public void setZgloszenie(ZgloszenieOB zgloszenie) {
        this.zgloszenie = zgloszenie;
    }

    public UserOB getUser() {
        return user;
    }

    public void setUser(UserOB user) {
        this.user = user;
    }
}
