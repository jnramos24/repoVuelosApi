package com.codoacodo.vuelosapi.services;

import com.codoacodo.vuelosapi.exceptions.ResourceNotFoundException;
import com.codoacodo.vuelosapi.models.Company;
import com.codoacodo.vuelosapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    public List<Company> allCompanies() {
        return companyRepository.findAll();
    }

    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    public Company findById(Long id){
        return companyRepository.findById(id).orElse(null);
    }

    public void deleteCompany(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("company","id",id));
        companyRepository.deleteById(company.getId());
    }

    public Company updateCompany(Company company) {
        companyRepository.save(company);
        return companyRepository.findById(company.getId()).orElse(null);
    }
}
