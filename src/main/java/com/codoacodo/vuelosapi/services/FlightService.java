package com.codoacodo.vuelosapi.services;

import com.codoacodo.vuelosapi.models.Flight;
import com.codoacodo.vuelosapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    public void createFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public Flight findById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        flightRepository.deleteById(id);
    }

    public Flight update(Flight flight) {
        flightRepository.save(flight);
        return flightRepository.findById(flight.getId()).orElse(null);
    }
}
