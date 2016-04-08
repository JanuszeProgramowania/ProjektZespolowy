package com.janusze.projektzespolowy.binaria.repository;

import com.janusze.projektzespolowy.binaria.ob.BinariaOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Repository
public interface IBinariaRepository extends JpaRepository<BinariaOB, Long> {
}
