package com.codoacodo.vuelosapi.services;

import com.codoacodo.vuelosapi.models.Flight;
import com.codoacodo.vuelosapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<Flight> offerFlights = new ArrayList<>();

        for(Flight flight : flights){
            if(flight.getPrice() < offerPrice){
                offerFlights.add(flight);
            }
        }

        return offerFlights;
    }
}
