package com.janusze.projektzespolowy.priorytet.ob;

import com.janusze.projektzespolowy.util.enums.ETypPriorytetu;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Created by Piotr Dordzik on 3/18/2016.
 */
@Data
@AllArgsConstructor
public class PriorytetOB{

    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private ETypPriorytetu typ;

}
