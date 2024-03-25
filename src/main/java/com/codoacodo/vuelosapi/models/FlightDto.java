package com.codoacodo.vuelosapi.models;

import lombok.Data;

@Data
public class FlightDto {
    private Long id;
    private String origen;
    private String destino;
    private String fechaHoraSalida;
    private String fechaHoraLlegada;
    private double convertedPrice;
}
