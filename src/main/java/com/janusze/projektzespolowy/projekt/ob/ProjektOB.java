package com.janusze.projektzespolowy.projekt.ob;


import com.janusze.projektzespolowy.user.ob.UserOB;
import com.janusze.projektzespolowy.zgloszenie.ob.ZgloszenieOB;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-03-18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projekty")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_PROJEKT_ID")
public class ProjektOB{
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
    @Column(name = "NAZWA")
    private String nazwa;
    @Column(name = "OPIS")
    private String opis;
    @Column(name = "WERSJA")
    private String wersja;
    @ManyToMany
    private List<UserOB> users;
    @OneToMany(mappedBy = "projekt")
    private List<ZgloszenieOB> zgloszenia;

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
