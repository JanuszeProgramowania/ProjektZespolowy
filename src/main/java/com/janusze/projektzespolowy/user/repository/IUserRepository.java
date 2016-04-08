package com.janusze.projektzespolowy.user.repository;

import com.janusze.projektzespolowy.user.ob.UserOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Repository
public interface IUserRepository extends JpaRepository<UserOB, Long> {
}
