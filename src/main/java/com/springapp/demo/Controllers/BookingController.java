package com.springapp.demo.Controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.demo.DAO.BookingDAO;
import com.springapp.demo.Models.Booking;
import com.springapp.demo.Services.BookingService;

@RestController
@Component
public class BookingController {
    
    @Autowired
    private BookingService bookingService;

    @Autowired
    private final BookingDAO bookingDAO;
    
    @Autowired
    public BookingController(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @PostMapping("/book-cab")
    public Booking bookCab(@RequestBody Booking booking) {
        try {
            String pickupAddress = booking.getPickupStreetAddress() + ", " + booking.getPickupCity() + ", " + booking.getPickupState() + " " + booking.getPickupZipCode();
            String destinationAddress = booking.getDestinationStreetAddress() + ", " + booking.getDestinationCity() + ", " + booking.getDestinationState() + " " + booking.getDestinationZipCode();
            
            // Calculate the fare based on the pickup and destination addresses
            Double fare = bookingService.bookCab(pickupAddress, destinationAddress);
            
            // Set the fare into the Booking object
            booking.setFare(BigDecimal.valueOf(fare));
            
            // Insert the Booking object into the Azure database using BookingDAO
            bookingDAO.saveBooking(booking);
            
            // Return the Booking object with the fare set
            return booking;
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception
            return null;
        }
    }
}

