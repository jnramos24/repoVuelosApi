package com.codoacodo.vuelosapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

   public Long getId() {
      return id;
   }

   public double getPrice() {
      return price;
   }
}
