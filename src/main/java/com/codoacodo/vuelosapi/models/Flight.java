package com.codoacodo.vuelosapi.models;


public class Flight {
   private Long id;
   private String origen;
   private String destino;
   private String fechaHoraSalida;
   private String fechaHoraLlegada;
   private double precio;
   private String frecuencia;

   public Flight() {
   }

   public Flight(Long id, String origen, String destino, String fechaHoraSalida, String fechaHoraLlegada, double precio, String frecuencia) {
      this.id = id;
      this.origen = origen;
      this.destino = destino;
      this.fechaHoraSalida = fechaHoraSalida;
      this.fechaHoraLlegada = fechaHoraLlegada;
      this.precio = precio;
      this.frecuencia = frecuencia;
   }

   public Long getId() {
      return id;
   }

   public String getOrigen() {
      return origen;
   }

   public String getDestino() {
      return destino;
   }

   public String getFechaHoraSalida() {
      return fechaHoraSalida;
   }

   public String getFechaHoraLlegada() {
      return fechaHoraLlegada;
   }

   public double getPrecio() {
      return precio;
   }

   public String getFrecuencia() {
      return frecuencia;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public void setOrigen(String origen) {
      this.origen = origen;
   }

   public void setDestino(String destino) {
      this.destino = destino;
   }

   public void setFechaHoraSalida(String fechaHoraSalida) {
      this.fechaHoraSalida = fechaHoraSalida;
   }

   public void setFechaHoraLlegada(String fechaHoraLlegada) {
      this.fechaHoraLlegada = fechaHoraLlegada;
   }

   public void setPrecio(double precio) {
      this.precio = precio;
   }

   public void setFrecuencia(String frecuencia) {
      this.frecuencia = frecuencia;
   }

   @Override
   public String toString() {
      return "Vuelo{" +
              "id=" + id +
              ", origen='" + origen + '\'' +
              ", destino='" + destino + '\'' +
              ", fechaHoraSalida=" + fechaHoraSalida +
              ", fechaHoraLlegada=" + fechaHoraLlegada +
              ", precio=" + precio +
              ", frecuencia='" + frecuencia + '\'' +
              '}';
   }
}
