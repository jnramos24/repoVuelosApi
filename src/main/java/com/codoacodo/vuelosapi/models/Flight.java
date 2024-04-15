package com.codoacodo.vuelosapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String origin;
   private String destiny;
   private String departureTime;
   private String arrivingTime;
   private double price;
   private String frequency;
   @ManyToOne
   @JoinColumn(name = "company_id")
   private Company company;

   public Flight(String origin, String destiny, String departureTime, String arrivingTime, double price, String frequency) {
      this.origin = origin;
      this.destiny = destiny;
      this.departureTime = departureTime;
      this.arrivingTime = arrivingTime;
      this.price = price;
      this.frequency = frequency;
   }
}
