package com.janusze.projektzespolowy.user.ob;

import com.janusze.projektzespolowy.company.ob.CompanyOB;
import com.janusze.projektzespolowy.util.enums.ETypUzytkownika;
import com.janusze.projektzespolowy.util.enums.EUserAuthority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_USER_ID")
public class UserOB{
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
    @Column(name = "AKTYWNY")
    private boolean aktywny;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "IMIE")
    private String name;
    @Column(name = "NAZWISKO")
    private String lastName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "TYP_UZYTKOWNIKA")
    private ETypUzytkownika typUzytkownika;
    @Column(name = "AUTHORITY")
    private EUserAuthority authority;
    @ManyToOne
    private CompanyOB company;



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
