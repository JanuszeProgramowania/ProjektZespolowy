package com.janusze.projektzespolowy.rola.ob;

import com.janusze.projektzespolowy.uprawnienie.ob.UprawnienieOB;
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
@Table(name = "role")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_ROLA_ID")
public class RolaOB{
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
    @Column(name = "NAZWA")
    private String nazwa;
    @ManyToMany
    private List<UprawnienieOB> uprawnienia;

    @PrePersist
    @PreUpdate
    private void setCurrentDate() {
        dataModyfikacji = new Date();
    }
}
