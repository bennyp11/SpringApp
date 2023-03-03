package com.springapp.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

   @GetMapping("/bookings")
   public String getBookings() {
      // This method should return the booking data in a format that can be displayed in the HTML template
      return "Booking data 123456789";
   }
}
