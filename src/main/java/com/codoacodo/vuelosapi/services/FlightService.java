package com.codoacodo.vuelosapi.services;

import com.codoacodo.vuelosapi.configuration.FlightConfiguration;
import com.codoacodo.vuelosapi.models.Dolar;
import com.codoacodo.vuelosapi.models.Flight;
import com.codoacodo.vuelosapi.repository.VuelosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    VuelosRepository vuelosRepository;

    @Autowired
    FlightConfiguration flightConfiguration;

    public List<Flight> traerTodosLosVuelos() {
        return vuelosRepository.findAll();
    }

    public void crearVuelo(Flight flight) {
        vuelosRepository.save(flight);
    }

    public Flight buscarVueloPorId(Long id) {

        return vuelosRepository.findById(id).orElse(null);
    }

    public void borrarVueloPorId(Long id) {

        vuelosRepository.deleteById(id);

    }


    public Flight actualizarVuelo(Flight flight) {
        vuelosRepository.save(flight);
        return vuelosRepository.findById(flight.getId()).orElse(null);
    }

    public double getDolar() {
        return flightConfiguration.fetchDolar().getPromedio();
    }
}
