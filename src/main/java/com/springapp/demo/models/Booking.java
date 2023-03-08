package com.springapp.demo.Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
   private String pickup;
   private String destination;
   private LocalDate date;
   private LocalTime time;
   private int passengers;

   public String getPickup() {
      return pickup;
   }

   public void setPickup(String pickup) {
      this.pickup = pickup;
   }

   public String getDestination() {
      return destination;
   }

   public void setDestination(String destination) {
      this.destination = destination;
   }

   public LocalDate getDate() {
      return date;
   }

   public void setDate(LocalDate date) {
      this.date = date;
   }

   public LocalTime getTime() {
      return time;
   }

   public void setTime(LocalTime time) {
      this.time = time;
   }

   public int getPassengers() {
      return passengers;
   }

   public void setPassengers(int passengers) {
      this.passengers = passengers;
   }
}
