package com.sobanscode.company.data.repository;

import com.sobanscode.company.data.entity.Company;

public interface ICompanyRepository {
    Company findCompanyByName(String companyName);
}
