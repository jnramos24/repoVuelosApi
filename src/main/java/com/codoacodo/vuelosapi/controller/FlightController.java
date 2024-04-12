package com.codoacodo.vuelosapi.controller;

import com.codoacodo.vuelosapi.models.Flight;
import com.codoacodo.vuelosapi.models.FlightDto;
import com.codoacodo.vuelosapi.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
@CrossOrigin("/*")
public class FlightController {
    @Autowired
    FlightService flightService;

    @GetMapping("")
    public List<FlightDto> getAllFlights(){
        return flightService.allFlights();
    }

    @PostMapping("/add")
    public Flight createFlight(@RequestBody Flight flight, @RequestParam Long companyId){
        return flightService.createFlight(flight, companyId);
    }

    @GetMapping("/{id}")
    public Flight findFlightById(@PathVariable Long id){
        return flightService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
    }

    @PutMapping("/update")
    public Flight updateFlight(@RequestBody Flight flight){
        return flightService.updateFlight(flight);
    }

    @GetMapping("/precio-dolar")
    public double getDolar(){
        return flightService.getDolar();
    }
}


