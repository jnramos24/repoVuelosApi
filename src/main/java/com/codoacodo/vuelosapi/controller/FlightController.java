package com.codoacodo.vuelosapi.controller;


import com.codoacodo.vuelosapi.models.Dolar;
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
    public List<Flight> getAllFlights(){
        return flightService.traerTodosLosVuelos();
    }

    @PostMapping("/agregar")
    public void createFlight(@RequestBody Flight flight){
        flightService.crearVuelo(flight);
    }

    @GetMapping("/{id}")
    public Flight findFlightById(@PathVariable Long id){
        return flightService.buscarVueloPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteFlight(@PathVariable Long id){

        flightService.borrarVueloPorId(id);
    }

    @PutMapping("/update")
    public Flight updateFlight(@RequestBody Flight flight){
        return flightService.actualizarVuelo(flight);
    }

    @GetMapping("/precio-dolar")
    public double getDolar(){
        return flightService.getDolar();
    }
}


