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

    public KomentarzOB()
    {

    }
}
