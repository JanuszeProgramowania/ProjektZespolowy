package com.janusze.projektzespolowy.priorytet.ob;

import com.janusze.projektzespolowy.util.enums.EJednostkaCzasu;
import com.janusze.projektzespolowy.util.enums.ETypPriorytetu;
import com.janusze.projektzespolowy.zgloszenie.ob.ZgloszenieOB;
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
@Table(name = "priorytety")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_PRIORYTET_ID")
public class PriorytetOB{
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
    @Column(name = "TYP")
    private ETypPriorytetu typ;
    @Column(name = "JEDNOSTKA")
    private EJednostkaCzasu jednostka;
    @Column(name = "ILOSC")
    private int ilosc;
    @OneToMany(mappedBy = "priorytet")
    private List<ZgloszenieOB> zgloszenia;

    @PrePersist
    @PreUpdate
    private void setCurrentDate() {
        dataModyfikacji = new Date();
    }
}
