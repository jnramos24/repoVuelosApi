package com.codoacodo.vuelosapi.controller;


import com.codoacodo.vuelosapi.models.Dolar;
import com.codoacodo.vuelosapi.models.Flight;
import com.codoacodo.vuelosapi.models.FlightDto;
import com.codoacodo.vuelosapi.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("")
    public List<FlightDto> getAllFlights(){
        return flightService.findAll();
    }

    @PostMapping("/add")
    public Flight createFlight(@RequestBody Flight flight, @RequestParam Long companyId){
        return flightService.createFlight(flight, companyId);
    }

    @GetMapping("/{id}")
    public Optional<Flight> findFlightById(@PathVariable Long id){
        return flightService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id){
        flightService.delete(id);
    }

    @PutMapping("/update")
    public Optional<Flight> updateFlight(@RequestBody Flight flight){
        return flightService.update(flight);
    }


    @GetMapping("/origin")
    public List<Flight> getFlightsByLocations(@RequestParam String origin) {
        return flightService.getByOrigin(origin);
    }

    @GetMapping("/offers")
    public List<Flight> getOffers(){
        Integer offerPrice = 200;
        return  flightService.getOffers(offerPrice);
    }

    @GetMapping("/locations")
    public List<Flight> getFlightsByLocations(@RequestParam String origin, @RequestParam String destiny) {
        return flightService.getByOriginAndDestiny(origin, destiny);
    }
}


