package com.janusze.projektzespolowy.rola.ob;

import com.janusze.projektzespolowy.uprawnienie.ob.UprawnienieOB;
import com.janusze.projektzespolowy.user.ob.UserOB;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
@Data
@AllArgsConstructor
public class RolaOB{
    private long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String nazwa;
    private List<UprawnienieOB> uprawnienia;
    private List<UserOB> users;

}
