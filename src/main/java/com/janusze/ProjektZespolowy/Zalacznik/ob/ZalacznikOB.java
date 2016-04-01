package com.janusze.projektzespolowy.zalacznik.ob;

import com.janusze.projektzespolowy.user.ob.UserOB;
import com.janusze.projektzespolowy.binaria.ob.BinariaOB;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Created by Piotr Dordzik on 3/18/2016.
 */
@Data
@AllArgsConstructor
public class ZalacznikOB{
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String mimeType;
    private String nazwa;
    private BinariaOB binaria;
    private UserOB user;

}
