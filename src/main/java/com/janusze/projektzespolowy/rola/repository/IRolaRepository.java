package com.janusze.projektzespolowy.rola.repository;

import com.janusze.projektzespolowy.rola.ob.RolaOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Repository
public interface IRolaRepository extends JpaRepository<RolaOB, Long> {
}
