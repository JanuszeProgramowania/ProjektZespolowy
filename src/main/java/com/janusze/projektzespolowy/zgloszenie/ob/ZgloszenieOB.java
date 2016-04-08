package com.janusze.projektzespolowy.zgloszenie.ob;

import com.janusze.projektzespolowy.historia.ob.HistoriaOB;
import com.janusze.projektzespolowy.priorytet.ob.PriorytetOB;
import com.janusze.projektzespolowy.projekt.ob.ProjektOB;
import com.janusze.projektzespolowy.user.ob.UserOB;
import com.janusze.projektzespolowy.util.enums.EStatusZgloszenia;
import com.janusze.projektzespolowy.util.enums.ETypZgloszenia;
import com.janusze.projektzespolowy.util.enums.EZgloszenieWewZew;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Piotr Dordzik on 3/18/2016.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "zgloszenia")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_ZGLOSZENIE_ID")
public class ZgloszenieOB{
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
    @Column(name = "OPIS")
    private String opis;
    @ManyToOne
    private PriorytetOB priorytet;
    @ManyToOne
    private ProjektOB projekt;
    @Column(name = "STATUS")
    private EStatusZgloszenia status;
    private ETypZgloszenia typZgloszenia;
    @OneToMany(mappedBy = "zgloszenie")
    private List<HistoriaOB> historia;
    @Column(name ="ZGLOSZENIE_WEW_ZEW")
    private EZgloszenieWewZew zgloszenieWewZew;
    @ManyToOne
    private UserOB user;

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
