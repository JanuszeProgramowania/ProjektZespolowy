package ProjektZespolowy.Zalacznik.ZalacznikOB;

/**
 * Created by Piotr Dordzik on 3/18/2016.
 */
public class ZalacznikOB {

    private long id;
    private long idBinaria;
    private long idZgloszenia;
    private String mimeType;
    private String nazwa;
    private String nazwaPliku;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdBinaria() {
        return idBinaria;
    }

    public void setIdBinaria(long idBinaria) {
        this.idBinaria = idBinaria;
    }

    public long getIdZgloszenia() {
        return idZgloszenia;
    }

    public void setIdZgloszenia(long idZgloszenia) {
        this.idZgloszenia = idZgloszenia;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwaPliku() {
        return nazwaPliku;
    }

    public void setNazwaPliku(String nazwaPliku) {
        this.nazwaPliku = nazwaPliku;
    }

    public ZalacznikOB()
    {

    }
}
