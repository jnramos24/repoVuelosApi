package com.codoacodo.vuelosapi.utils;

import com.codoacodo.vuelosapi.models.Dolar;
import com.codoacodo.vuelosapi.models.Flight;
import com.codoacodo.vuelosapi.models.FlightDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightUtils {
    public List<FlightDto> flightMapper(List<Flight> flights, double dolarPrice){
        List<FlightDto> flightDtos = new ArrayList<>();
        for(Flight flight : flights){
            flightDtos.add(new FlightDto(flight.getId(), flight.getOrigin(), flight.getDestiny(),
                    flight.getDepartureDate(), flight.getArrivingDate(),
                    flight.getFrequency(),dolarPrice*flight.getPrice(), flight.getCompany()));
        }
        return flightDtos;
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public Dolar fetchDolar(){
        RestTemplate restTemplate = restTemplate();
        String apiUrl = "https://dolarapi.com/v1/dolares/tarjeta";
        return restTemplate.getForObject(apiUrl, Dolar.class);
    }
 }
