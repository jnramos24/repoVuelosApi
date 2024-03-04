package com.codoacodo.vuelosapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String origen;
   private String destino;
   private String fechaHoraSalida;
   private String fechaHoraLlegada;
   private double precio;
   private String frecuencia;

   public Flight(String origen, String destino, String fechaHoraSalida, String fechaHoraLlegada, double precio, String frecuencia) {
      this.origen = origen;
      this.destino = destino;
      this.fechaHoraSalida = fechaHoraSalida;
      this.fechaHoraLlegada = fechaHoraLlegada;
      this.precio = precio;
      this.frecuencia = frecuencia;
   }
}
