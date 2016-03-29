package ProjektZespolowy;

import java.util.Date;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
public class BaseOB {
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;

    public BaseOB(long id, Date dataUtworzenia, Date dataModyfikacji) {
        this.id = id;
        this.dataUtworzenia = dataUtworzenia;
        this.dataModyfikacji = dataModyfikacji;
    }

    public Date getDataUtworzenia() {

        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataModyfikacji() {
        return dataModyfikacji;
    }

    public void setDataModyfikacji(Date dataModyfikacji) {
        this.dataModyfikacji = dataModyfikacji;
    }


}
