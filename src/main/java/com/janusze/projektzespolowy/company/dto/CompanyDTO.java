package com.janusze.projektzespolowy.company.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Tomasz Jodko on 2016-06-04.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class CompanyDTO {
    private Long id;
    private Date dataUtworzenia;
    private Date dataModyfikacji;
    private String name;
    private String address;
    private String city;
    private String phone;

}
