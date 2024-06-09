package com.sobanscode.company.data.repository;

import com.sobanscode.company.data.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company, Long> {
    Company findCompanyByName(String companyName);
}
