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

    public ZgloszenieOB()
    {

    }

}
