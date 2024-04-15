package com.codoacodo.vuelosapi.controller;

import com.codoacodo.vuelosapi.exceptions.ResourceNotFoundException;
import com.codoacodo.vuelosapi.models.Company;
import com.codoacodo.vuelosapi.services.CompanyService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpClient;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("")
    public List<Company> getAllCompanies() {
        return companyService.allCompanies();
    }

    @PostMapping("/add")
    public void createFlight(@RequestBody Company company) {
        companyService.createCompany(company);
    }

    @GetMapping("/{id}")
    public Company findFlightById(@PathVariable Long id) {
        return companyService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFlight(@PathVariable Long id) {

        try {
            companyService.deleteCompany(id);
            return "Compania eliminada con exito";

        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return "No existe la compania con el Id seleccionado";
        }

    }

    @PutMapping("/update")
    public Company updateCompany(@RequestBody Company company) {
        return companyService.updateCompany(company);
    }

}
