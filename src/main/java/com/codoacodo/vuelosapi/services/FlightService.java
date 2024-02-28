package com.codoacodo.vuelosapi.services;

import com.codoacodo.vuelosapi.models.Flight;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FlightService {

    // creo una lista
    // cambié la creación de la lista para que no tengan que llamar a "agregarVuelos()" en cada método.
    private List<Flight> flightList = Arrays.asList(
            new Flight(1L,"Puerto Madryn","Cordoba","24-02-2024","25-02-2024",200.00, "mensual"),
            new Flight(2L,"Madryn","Cordoba Capital","25-02-2024","26-02-2024",300.00, "diaria"),
            new Flight(3L,"Puerto","Cordoba Provincia","26-02-2024","27-02-2024",400.00, "anual")
    );

    // creo 3 vuelos para cargar
  //  Flight flight1 = new Flight(1L,"Puerto Madryn","Cordoba","24-02-2024","25-02-2024",200.00, "mensual");
  //  Flight flight2 = new Flight(2L,"Madryn","Cordoba Capital","25-02-2024","26-02-2024",300.00, "diria");
   // Flight flight3 = new Flight(3L,"Puerto","Cordoba Provincia","26-02-2024","27-02-2024",400.00, "anual");

    // cargo los vuelos en la lista
//    public void agregarVuelos(){
//        flightList.add(flight1);
//        flightList.add(flight2);
//        flightList.add(flight3);
//    }
    public Flight devolverVuelo(){
        //agregarVuelos();
        return flightList.get(0);
    }

    public List<Flight> traerTodosLosVuelos(){
        //agregarVuelos();
        return flightList;
    }

    public void crearVuelo(){
        //agregarVuelos();
        flightList.add(new Flight(4L,"Puerto Piramides","Tucuman","26-02-2024","27-02-2024",400.00, "anual"));
    }
    public Flight buscarVueloPorId(Long id) {
        //agregarVuelos();

        for (int i = 0; i < flightList.size(); i++) {
            if (flightList.get(i).getId() == id){
                return flightList.get(i);
            }
        }
        return null;
    }

    public void borrarVueloPorId(Long id) {
        Flight vueloABorrar = buscarVueloPorId(id);
        flightList.remove(vueloABorrar);
    }
}
