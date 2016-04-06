package com.janusze.projektzespolowy.zalacznik.ob;

import com.janusze.projektzespolowy.binaria.ob.BinariaOB;
import com.janusze.projektzespolowy.historia.ob.HistoriaOB;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Piotr Dordzik on 3/18/2016.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "zalaczniki")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_ZALACZNIK_ID")
public class ZalacznikOB{
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
    @Column(name="MIME_TYPE")
    private String mimeType;
    @Column(name="NAZWA")
    private String nazwa;
    @OneToOne
    private BinariaOB binaria;
    @ManyToOne
    private HistoriaOB historia;

    @PrePersist
    @PreUpdate
    private void setCurrentDate() {
        dataModyfikacji = new Date();
    }

}
