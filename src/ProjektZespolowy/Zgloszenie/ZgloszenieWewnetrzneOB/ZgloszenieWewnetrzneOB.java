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

    public ZgloszenieWewnetrzneOB()
    {

    }
}
