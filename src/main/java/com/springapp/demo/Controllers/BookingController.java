package com.springapp.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.demo.Models.Booking;
import com.springapp.demo.Services.BookingService;

@RestController
public class BookingController {
    
    @Autowired
    private BookingService bookingService;

    @PostMapping("/book-cab")
    public String bookCab(@RequestBody Booking booking) {
        try {
            String pickupAddress = booking.getPickupStreetAddress() + ", " + booking.getPickupCity() + ", " + booking.getPickupState() + " " + booking.getPickupZipCode();
            String destinationAddress = booking.getDestinationStreetAddress() + ", " + booking.getDestinationCity() + ", " + booking.getDestinationState() + " " + booking.getDestinationZipCode();
            
            // Calculate the fare based on the pickup and destination addresses
            Double fare = bookingService.bookCab(pickupAddress, destinationAddress);
            
            // Return the fare as a JSON object
            return "{\"fare\": \"" + fare + "\"}";
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception
            return "{\"error\": \"" + e.getMessage() + "\"}";
        }
    }
}
