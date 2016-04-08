package com.janusze.projektzespolowy.historia.repository;

import com.janusze.projektzespolowy.historia.ob.HistoriaOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Repository
public interface IHistoriaRepository extends JpaRepository<HistoriaOB, Long> {
}
