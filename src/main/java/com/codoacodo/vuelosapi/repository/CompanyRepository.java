package com.codoacodo.vuelosapi.repository;

import com.codoacodo.vuelosapi.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
