package com.sobanscode.company.controller;

import com.sobanscode.company.data.entity.Company;
import com.sobanscode.company.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.sobanscode.company.constants.ApiUrl.*;

@RestController
@RequestMapping(COMPANIES)
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping(FIND_BY_NAME)
    public ResponseEntity<Company> getCompanyByName(@RequestParam("companyName") String companyName){
        return ResponseEntity.ok(companyService.getCompanyByName(companyName));
    }
}
