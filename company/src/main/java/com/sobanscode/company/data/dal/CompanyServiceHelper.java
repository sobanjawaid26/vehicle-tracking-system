package com.sobanscode.company.data.dal;

import com.sobanscode.company.data.entity.Company;
import com.sobanscode.company.data.repository.ICompanyRepository;
import org.springframework.stereotype.Component;

@Component
public class CompanyServiceHelper {

    private final ICompanyRepository companyRepository;

    public CompanyServiceHelper(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company getCompanyByName(String companyName){
        return companyRepository.findCompanyByName(companyName);
    }
}
