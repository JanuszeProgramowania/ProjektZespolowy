package com.janusze.projektzespolowy.user.repository;

import com.janusze.projektzespolowy.user.ob.UserOB;
import com.janusze.projektzespolowy.util.enums.ETypUzytkownika;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-04-08.
 */
@Repository
public interface IUserRepository extends JpaRepository<UserOB, Long> {

    @Query("SELECT u FROM UserOB u WHERE u.name = ?1 AND u.lastName = ?2")
    List<UserOB> findByFullName(String aName, String aLastName);

    @Query("SELECT u FROM UserOB u WHERE u.email = ?1")
    UserOB findByEmail(String email);

    @Query("SELECT  u FROM UserOB u WHERE  u.company.id = ?1")
    List<UserOB> findByCompanyId(Long aId);

    @Query("SELECT u FROM UserOB u WHERE u.typUzytkownika =?1")
    List<UserOB> findByUserType(ETypUzytkownika aType);

}
