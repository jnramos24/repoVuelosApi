package com.codoacodo.vuelosapi.controller;


import com.codoacodo.vuelosapi.models.Flight;
import com.codoacodo.vuelosapi.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("")
    public List<Flight> getAllFlights(){
        return flightService.findAll();
    }

    @PostMapping("/add")
    public void createFlight(@RequestBody Flight flight){
        flightService.createFlight(flight);
    }

    @GetMapping("/{id}")
    public Flight findFlightById(@PathVariable Long id){
        return flightService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id){
        flightService.delete(id);
    }

    @PutMapping("/update")
    public Flight updateFlight(@RequestBody Flight flight){
        return flightService.update(flight);
    }

    /*
    @GetMapping("/locations")
    public List<Flight> getFlightsByLocations(@RequestParam String origin, @RequestParam String destiny) {
        return flightService.getByOriginAndDestiny(origin, destiny);
    } */
}


