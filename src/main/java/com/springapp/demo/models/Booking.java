package com.springapp.demo.Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
   private String pickupStreetAddress;
   private String pickupCity;
   private String pickupState;
   private String pickupZipCode;
   private String destinationStreetAddress;
   private String destinationCity;
   private String destinationState;
   private String destinationZipCode;
   private LocalDate date;
   private LocalTime time;
   private int passengers;

   public String getPickupStreetAddress() {
      return pickupStreetAddress;
   }

   public void setPickupStreetAddress(String pickupStreetAddress) {
      this.pickupStreetAddress = pickupStreetAddress;
   }

   public String getPickupCity() {
      return pickupCity;
   }

   public void setPickupCity(String pickupCity) {
      this.pickupCity = pickupCity;
   }

   public String getPickupState() {
      return pickupState;
   }

   public void setPickupState(String pickupState) {
      this.pickupState = pickupState;
   }

   public String getPickupZipCode() {
      return pickupZipCode;
   }

   public void setPickupZipCode(String pickupZipCode) {
      this.pickupZipCode = pickupZipCode;
   }

   public String getDestinationStreetAddress() {
      return destinationStreetAddress;
   }

   public void setDestinationStreetAddress(String destinationStreetAddress) {
      this.destinationStreetAddress = destinationStreetAddress;
   }

   public String getDestinationCity() {
      return destinationCity;
   }

   public void setDestinationCity(String destinationCity) {
      this.destinationCity = destinationCity;
   }

   public String getDestinationState() {
      return destinationState;
   }

   public void setDestinationState(String destinationState) {
      this.destinationState = destinationState;
   }

   public String getDestinationZipCode() {
      return destinationZipCode;
   }

   public void setDestinationZipCode(String destinationZipCode) {
      this.destinationZipCode = destinationZipCode;
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
