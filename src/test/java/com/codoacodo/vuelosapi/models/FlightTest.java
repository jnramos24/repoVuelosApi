package com.codoacodo.vuelosapi.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FlightTest {
    private static Flight flight;

    @Test
    public void setAndGetOriginTest(){
        String testedOrigin = "EZE";
        flight.setOrigin(testedOrigin);
        Assertions.assertEquals(flight.getOrigin(), testedOrigin);
    }

    @Test
    public void  setAndGetDestinyTest(){
        String testedDestiny = "COR";
        flight.setDestiny(testedDestiny);
        Assertions.assertEquals(flight.getDestiny(), testedDestiny);
    }

    @BeforeAll
    public static void setUp(){
        flight = new Flight();
    }
}