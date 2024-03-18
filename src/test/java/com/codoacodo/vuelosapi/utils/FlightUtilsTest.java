package com.codoacodo.vuelosapi.utils;

import com.codoacodo.vuelosapi.models.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class FlightUtilsTest {

    @Autowired
    FlightUtils flightUtils;

    @Test
    void detectOffersTest() {
        List<Flight> flights = new ArrayList<>();
        int maxPrice = 200;

        flights.add(new Flight(1L, 100.0));
        flights.add(new Flight(2L, 200.0));
        flights.add(new Flight(3L, 150.0));
        flights.add(new Flight(4L, 300.0));

        List<Flight> offers = flightUtils.detectOffers(flights, maxPrice);

        Assertions.assertEquals(2, offers.size());
        Assertions.assertEquals(1, offers.get(0).getId());
        Assertions.assertEquals(3, offers.get(1).getId());
    }
}