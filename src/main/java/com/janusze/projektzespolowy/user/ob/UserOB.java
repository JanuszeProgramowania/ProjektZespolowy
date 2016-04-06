package com.janusze.projektzespolowy.user.ob;

import com.janusze.projektzespolowy.historia.ob.HistoriaOB;
import com.janusze.projektzespolowy.projekt.ob.ProjektOB;
import com.janusze.projektzespolowy.rola.ob.RolaOB;
import com.janusze.projektzespolowy.util.enums.ETypUzytkownika;
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
@Table(name = "users")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_USER_ID")
public class UserOB{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    private long id;
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
    private String imie;
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Column(name = "PASSWORD_MD5")
    private String passwordMd5;
    @ManyToMany(mappedBy = "users")
    private List<ProjektOB> projekty;
    @ManyToMany
    private List<RolaOB> role;
    @Column(name = "TYP_UZYTKOWNIKA")
    private ETypUzytkownika typUzytkownika;
    @OneToMany(mappedBy = "user")
    private List<ZgloszenieOB> zgloszenia;
    @OneToMany(mappedBy = "user")
    private List<HistoriaOB> historia;


    @PrePersist
    @PreUpdate
    private void setCurrentDate() {
        // przy kazdym wpisie lub zmianie rekordu bedzie aktualizowana jego data, przydatne pole przy utrzymywaniu systemu
        dataModyfikacji = new Date();
    }
}
