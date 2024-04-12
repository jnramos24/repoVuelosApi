package com.codoacodo.vuelosapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
   private String origin;
   private String destiny;
   private String departureDate;
   private String arrivingDate;
   private double price;
   private String frequency;
   @ManyToOne
   @JoinColumn(name = "company_id")
   private Company company;
}
