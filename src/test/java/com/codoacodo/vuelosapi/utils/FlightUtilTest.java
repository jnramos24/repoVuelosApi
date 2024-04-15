package com.codoacodo.vuelosapi.utils;

import com.codoacodo.vuelosapi.models.Dolar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FlightUtilTest {

    @Test
    void fetchDolarTest() {
        // genero el contexto
        FlightUtils mockedFlightUtils = mock(FlightUtils.class);

        Dolar dummyDolar = new Dolar();

        dummyDolar.setMoneda("USD");
        dummyDolar.setCasa("tarjeta");
        dummyDolar.setNombre("Tarjeta");
        dummyDolar.setVenta(1000.00);
        dummyDolar.setCompra(1200.00);

        when(mockedFlightUtils.fetchDolar()).thenReturn(dummyDolar);

        // llamo la funcionalidad
        Dolar dolar = mockedFlightUtils.fetchDolar();
        //verifico las salidas
        assertEquals(1100.00, dolar.getPromedio());
    }
}
