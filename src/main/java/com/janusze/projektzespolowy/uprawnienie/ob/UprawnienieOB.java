package com.janusze.projektzespolowy.uprawnienie.ob;

import com.janusze.projektzespolowy.rola.ob.RolaOB;
import lombok.AllArgsConstructor;
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
@Table(name = "uprawnienia")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_UPRAWNIENIE_ID")
public class UprawnienieOB{
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
    @Column(name="NAZWA")
    private String nazwa;
    @ManyToOne
    private RolaOB rola;

    @PrePersist
    @PreUpdate
    private void setCurrentDate() {
        dataModyfikacji = new Date();
    }
}
