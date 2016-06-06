package com.janusze.projektzespolowy.company.service.impl;

import com.janusze.projektzespolowy.company.dto.CompanyDTO;
import com.janusze.projektzespolowy.company.ob.CompanyOB;
import com.janusze.projektzespolowy.company.repository.ICompanyRepository;
import com.janusze.projektzespolowy.company.service.ICompanyService;
import com.janusze.projektzespolowy.projekt.dto.ProjektDTO;
import com.janusze.projektzespolowy.projekt.service.IProjektService;
import com.janusze.projektzespolowy.util.converters.impl.CompanyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-06-04.
 */
@Service
@Transactional
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    ICompanyRepository iCompanyRepository;
    @Autowired
    CompanyConverter companyConverter;
    @Autowired
    IProjektService projektService;

    @Override
    public CompanyDTO findCompanyById(Long aId) {
        CompanyOB pCompanyOB = iCompanyRepository.findOne(aId);
        if (pCompanyOB == null) {
            return null;
        }
        return companyConverter.mapOBtoDTO(pCompanyOB);
    }

    @Override
    public List<CompanyDTO> findAllCompanies() {
        List<CompanyDTO> pResult = new ArrayList<>();
        List<CompanyOB> pCompanyList = iCompanyRepository.findAll();
        for (CompanyOB company : pCompanyList) {
            pResult.add(companyConverter.mapOBtoDTO(company));
        }
        return pResult;
    }

    @Override
    public CompanyDTO saveCompany(CompanyDTO aCompanyDTO) {
        if (aCompanyDTO == null) {
            return null;
        }
        CompanyOB pCompanyOB = aCompanyDTO.getId() == null ? null : iCompanyRepository.findOne(aCompanyDTO.getId());

        if (pCompanyOB == null) {
            return companyConverter.mapOBtoDTO(iCompanyRepository.save(companyConverter.mapDTOtoOB(aCompanyDTO)));
        }
        pCompanyOB.setName(aCompanyDTO.getName());
        pCompanyOB.setAddress(aCompanyDTO.getAddress());
        pCompanyOB.setCity(aCompanyDTO.getCity());
        pCompanyOB.setPhone(aCompanyDTO.getPhone());
        return companyConverter.mapOBtoDTO(iCompanyRepository.save(pCompanyOB));
    }


    @Override
    public List<CompanyDTO> findCompaniesInProjekt(Long aProjektId){
        ProjektDTO pProjektDTO = projektService.findProjektById(aProjektId);
        if(pProjektDTO != null){
            List<CompanyDTO> pProjektCompanies = new ArrayList<>();
            pProjektCompanies.addAll(pProjektDTO.getCompanies());
            return pProjektCompanies;
        }
        return null;
    }

    @Override
    public List<CompanyDTO> findCompaniesNotInProjekt(Long aProjektId){
        ProjektDTO pProjektDTO = projektService.findProjektById(aProjektId);
        if(pProjektDTO != null){
            List<CompanyDTO> pProjektCompanies = new ArrayList<>();
            pProjektCompanies.addAll(pProjektDTO.getCompanies());
            List<CompanyDTO> pAllCompanies = findAllCompanies();
            pAllCompanies.removeAll(pProjektCompanies);
            return pAllCompanies;
        }
        return null;
    }


    @Override
    public void deleteCompany(Long aId) {
        iCompanyRepository.delete(aId);
    }
}
