package com.codoacodo.vuelosapi.services;

import com.codoacodo.vuelosapi.models.Company;
import com.codoacodo.vuelosapi.models.Flight;
import com.codoacodo.vuelosapi.models.FlightDto;
import com.codoacodo.vuelosapi.repository.CompanyRepository;
import com.codoacodo.vuelosapi.repository.FlightRepository;
import com.codoacodo.vuelosapi.utils.FlightUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    FlightUtils flightUtils;

    public List<FlightDto> allFlights() {
        double dolarPrice = getDolar();
        List<Flight> flights = flightRepository.findAll();
        return flightUtils.flightMapper(flights, dolarPrice);
    }

    public Flight createFlight(Flight flight, Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));

        flight.setCompany(company);
        return flightRepository.save(flight);
    }

    public Flight findById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public Flight updateFlight(Flight flight) {
        flightRepository.save(flight);
        return flightRepository.findById(flight.getId()).orElse(null);
    }

    public double getDolar() {
        return flightUtils.fetchDolar().getPromedio();
    }
}
