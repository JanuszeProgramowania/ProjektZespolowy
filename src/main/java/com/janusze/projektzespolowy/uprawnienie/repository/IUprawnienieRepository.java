package com.janusze.projektzespolowy.uprawnienie.repository;

import com.janusze.projektzespolowy.uprawnienie.ob.UprawnienieOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Repository
public interface IUprawnienieRepository extends JpaRepository<UprawnienieOB, Long> {
}
