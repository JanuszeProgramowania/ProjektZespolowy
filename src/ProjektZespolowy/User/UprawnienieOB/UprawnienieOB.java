package ProjektZespolowy.User.UprawnienieOB;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
public class UprawnienieOB {
    private long id;
    private String nazwa;

    public UprawnienieOB(long id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
