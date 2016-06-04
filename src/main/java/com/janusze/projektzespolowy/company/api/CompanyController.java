package com.janusze.projektzespolowy.company.api;

import com.janusze.projektzespolowy.company.dto.CompanyDTO;
import com.janusze.projektzespolowy.company.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tomasz Jodko on 2016-06-04.
 */
@RestController
@Transactional
@RequestMapping(value = "/projektzespolowy/companies")
public class CompanyController {

    @Autowired
    ICompanyService companyService;

    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    public ResponseEntity<CompanyDTO> findCompanyById(@PathVariable("id") Long aId) {
        return new ResponseEntity<>(companyService.findCompanyById(aId), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<CompanyDTO>> findAllCompanies() {
        return new ResponseEntity<>(companyService.findAllCompanies(), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveCompany", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<CompanyDTO> savePriorytet(@RequestBody CompanyDTO aCompanyDTO) {
        return new ResponseEntity<>(companyService.saveCompany(aCompanyDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> deleteCompany(@PathVariable("id") Long aId) {
        companyService.deleteCompany(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
