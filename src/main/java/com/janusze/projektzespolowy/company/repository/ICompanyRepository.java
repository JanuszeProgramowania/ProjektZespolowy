package com.janusze.projektzespolowy.company.repository;

import com.janusze.projektzespolowy.company.ob.CompanyOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomasz Jodko on 2016-06-04.
 */
@Repository
public interface ICompanyRepository extends JpaRepository<CompanyOB, Long> {
}
