package com.janusze.projektzespolowy.projekt.repository;

import com.janusze.projektzespolowy.projekt.ob.ProjektOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Repository
public interface IProjektRepository extends JpaRepository<ProjektOB, Long> {
    @Query("SELECT  a FROM ProjektOB a INNER JOIN a.users u WHERE u.id = ?1 ")
    List<ProjektOB> findByUserId(Long aId);
}
