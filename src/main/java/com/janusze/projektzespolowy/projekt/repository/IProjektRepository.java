package com.janusze.projektzespolowy.projekt.repository;

import com.janusze.projektzespolowy.projekt.ob.ProjektOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Repository
public interface IProjektRepository extends JpaRepository<ProjektOB, Long> {
}
