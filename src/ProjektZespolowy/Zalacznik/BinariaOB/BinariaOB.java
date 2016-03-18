package ProjektZespolowy.Zalacznik.BinariaOB;

import ProjektZespolowy.BaseOB.BaseOB;

import java.util.Date;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
public class BinariaOB extends BaseOB{
    private Byte[] bin;

    public BinariaOB(long id, Date dataUtworzenia, Date dataModyfikacji, Byte[] bin) {
        super(id, dataUtworzenia, dataModyfikacji);
        this.bin = bin;
    }

    public Byte[] getBin() {
        return bin;
    }

    public void setBin(Byte[] bin) {
        this.bin = bin;
    }
}
