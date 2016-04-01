package com.janusze.projektzespolowy.binaria.ob;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
@Data
@AllArgsConstructor
public class BinariaOB{
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private Byte[] bin;

}
