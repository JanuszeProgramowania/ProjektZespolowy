package com.janusze.projektzespolowy.zgloszenie.repository;

import com.janusze.projektzespolowy.zgloszenie.ob.ZgloszenieOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Repository
public interface IZgloszenieRepository extends JpaRepository<ZgloszenieOB, Long> {
}
