package com.janusze.projektzespolowy.uprawnienie.ob;

import com.janusze.projektzespolowy.rola.ob.RolaOB;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
@Data
@AllArgsConstructor
public class UprawnienieOB{
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String nazwa;
    private List<RolaOB> role;

}
