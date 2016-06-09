package com.janusze.projektzespolowy.zgloszenie.repository;

import com.janusze.projektzespolowy.util.enums.ETypPriorytetu;
import com.janusze.projektzespolowy.zgloszenie.ob.ZgloszenieOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Repository
public interface IZgloszenieRepository extends JpaRepository<ZgloszenieOB, Long> {
    @Query("SELECT  a FROM ZgloszenieOB a WHERE  a.user.id = ?1")
    List<ZgloszenieOB> findByUserId(Long aId);

    @Query("SELECT  a FROM ZgloszenieOB a WHERE  a.projekt.id = ?1")
    List<ZgloszenieOB> findByProjektId(Long aId);

    @Query("SELECT  a FROM ZgloszenieOB a WHERE  a.user.id = ?1 AND a.projekt.id = ?2")
    List<ZgloszenieOB> findByUserAndProjektId(Long aUserId,Long aProjektId);

    @Query("SELECT  a FROM ZgloszenieOB a WHERE  a.priorytet.typ = ?1")
    List<ZgloszenieOB> findByPriorytetType(ETypPriorytetu typPriorytetu);
}
