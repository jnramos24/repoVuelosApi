package com.codoacodo.vuelosapi.utils;

import com.codoacodo.vuelosapi.models.Dolar;
import com.codoacodo.vuelosapi.models.Flight;
import com.codoacodo.vuelosapi.models.FlightDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightUtils {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public List<Flight> detectOffers(List<Flight> flights, Integer offerPrice) {
        return flights.stream()
                .filter(flight -> flight.getPrice() < offerPrice)
                .collect(Collectors.toList());
    }

    public FlightDto flightMapper(Flight flight, double price){
        return new FlightDto(flight.getId(),flight.getOrigin(), flight.getDestiny(), flight.getDepartureTime(),
                flight.getArrivingTime(), flight.getPrice() * price, flight.getFrequency(), flight.getCompany());
    }

    public Dolar fetchDolar(){
        RestTemplate restTemplate = restTemplate();
        String apiUrl = "https://dolarapi.com/v1/dolares/tarjeta";
        return restTemplate.getForObject(apiUrl, Dolar.class);
    }
}
