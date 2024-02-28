package com.codoacodo.vuelosapi.controller;


import com.codoacodo.vuelosapi.models.Flight;
import com.codoacodo.vuelosapi.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("")
    public Flight getFlight(){
      return flightService.devolverVuelo();
    }

    @GetMapping("/todos")
    public List<Flight> getAllFlights(){
        return flightService.traerTodosLosVuelos();
    }

    @PostMapping("/agregar")
    public void createFlight(){
        flightService.crearVuelo();
    }

    @GetMapping("/id")
    public Flight findFlightById(){
        Long id = 3L;
        Flight vueloEncontrado = flightService.buscarVueloPorId(id);
        return vueloEncontrado;
    }

    @DeleteMapping("/eliminar")
    public void deleteFlight(){
        Long id = 3L;
        flightService.borrarVueloPorId(id);
    }




}


