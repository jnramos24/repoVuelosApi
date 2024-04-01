package com.codoacodo.vuelosapi.models;

import lombok.Data;

@Data
public class FlightDto {
    private Long id;
    private String origin;
    private String destiny;
    private String departureDate;
    private String arrivingDate;
    private double convertedPrice;
}
