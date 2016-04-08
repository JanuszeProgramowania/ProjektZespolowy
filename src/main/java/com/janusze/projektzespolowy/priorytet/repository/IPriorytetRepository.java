package com.janusze.projektzespolowy.priorytet.repository;

import com.janusze.projektzespolowy.priorytet.ob.PriorytetOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Repository
public interface IPriorytetRepository extends JpaRepository<PriorytetOB, Long> {
}
