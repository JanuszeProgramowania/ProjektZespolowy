package com.janusze.projektzespolowy.zalacznik.repository;

import com.janusze.projektzespolowy.zalacznik.ob.ZalacznikOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Repository
public interface IZalacznikRepository extends JpaRepository<ZalacznikOB, Long> {
}
