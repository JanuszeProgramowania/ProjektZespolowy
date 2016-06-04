package com.janusze.projektzespolowy.company.service;

import com.janusze.projektzespolowy.company.dto.CompanyDTO;

import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-06-04.
 */
public interface ICompanyService {

    CompanyDTO findCompanyById(Long aId);

    List<CompanyDTO> findAllCompanies();

    CompanyDTO saveCompany(CompanyDTO aCompanyDTO);

    void deleteCompany(Long aId);
}
