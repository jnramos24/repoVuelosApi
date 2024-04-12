package com.codoacodo.vuelosapi.utils;

import com.codoacodo.vuelosapi.models.Dolar;
import com.codoacodo.vuelosapi.models.Flight;
import com.codoacodo.vuelosapi.models.FlightDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class FlightUtilsTest {

    @Autowired
    FlightUtils flightUtils;

    @Test
    void flightMapperTest() {
        double dolarPrice = 1015;
        List<Flight> flightList = new ArrayList<>();
        List<FlightDto> flightDtoList = new ArrayList<>();

        Flight flight = new Flight();
        flight.setId(1L);
        flight.setOrigin("COR");
        flight.setDestiny("EZE");
        flight.setArrivingDate("SomeDate");
        flight.setDepartureDate("AnotherDate");
        flight.setPrice(100);
        flight.setFrequency("Weekly");

        flightList.add(flight);
        //Llamo al metodo a testear y le paso el contexto de prueba
        flightDtoList = flightUtils.flightMapper(flightList, dolarPrice);
        FlightDto flightDto = flightDtoList.get(0);

        assertEquals(1, flightDto.getId());
        assertEquals(flight.getPrice() * dolarPrice, flightDto.getConvertedPrice());
    }

    @Test
    void fetchDolarTest() {
        Dolar dummyDolar = new Dolar();

        dummyDolar.setVenta(1200);
        dummyDolar.setCompra(1300);

        FlightUtils mockedFlightUtils = mock(FlightUtils.class);
        when(mockedFlightUtils.fetchDolar()).thenReturn(dummyDolar);

        Dolar dolar = mockedFlightUtils.fetchDolar();

        assertEquals(1250, dolar.getPromedio());
    }
}