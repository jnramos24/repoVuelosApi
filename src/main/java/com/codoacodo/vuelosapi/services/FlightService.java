package com.codoacodo.vuelosapi.services;

import com.codoacodo.vuelosapi.configuration.FlightConfiguration;
import com.codoacodo.vuelosapi.models.Dolar;
import com.codoacodo.vuelosapi.models.Flight;
import com.codoacodo.vuelosapi.models.FlightDto;
import com.codoacodo.vuelosapi.repository.FlightRepository;
import com.codoacodo.vuelosapi.utils.FlightUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightUtils flightUtils;

    @Autowired
    FlightConfiguration flightConfiguration;

    public List<FlightDto> findAll() {
        List<Flight> flightList = flightRepository.findAll();
        return flightList.stream()
                .map(flight -> flightUtils.flightMapper(flight,getDolar()))
                .collect(Collectors.toList());
    }

    public void createFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public Optional<Flight> findById(Long id) {
        return flightRepository.findById(id);
    }

    public void delete(Long id) {
        flightRepository.deleteById(id);
    }

    public Optional<Flight> update(Flight flight) {
        flightRepository.save(flight);
        return flightRepository.findById(flight.getId());
    }

    public  List<Flight> getByOrigin(String origin){
        return flightRepository.findByOrigin(origin);
    }

    public  List<Flight> getByOriginAndDestiny(String origin, String destiny){
        return flightRepository.findByOriginAndDestiny(origin, destiny);
    }

    public List<Flight> getOffers(Integer offerPrice){
        List<Flight> flights = flightRepository.findAll();
        return flightUtils.detectOffers(flights, offerPrice);
    }

    private double getDolar() {
        Dolar dolar = flightConfiguration.fetchDolar();
        return dolar.getPromedio();
    }

    public List<Dolar> getAllDolars() {
        return List.of(flightConfiguration.fetchAllDolars());
    }
}

