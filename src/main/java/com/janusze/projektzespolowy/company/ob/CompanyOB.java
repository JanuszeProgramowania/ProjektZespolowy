package com.janusze.projektzespolowy.company.ob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tomasz Jodko on 2016-06-04.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "companies")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_COMPANY_ID")
public class CompanyOB {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private Long id;
    @Column(name = "DATA_UTWORZENIA", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dataUtworzenia;
    @Column(name = "DATA_MODYFIKACJI", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dataModyfikacji;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "CITY")
    private String city;
    @Column(name = "PHONE")
    private String phone;

    @PreUpdate
    private void setModDate() {
        dataModyfikacji = new Date();
    }

    @PrePersist
    private void setCreationDate(){
        dataModyfikacji = new Date();
        dataUtworzenia = new Date();
    }
}
