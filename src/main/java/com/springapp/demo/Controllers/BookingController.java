package com.springapp.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.demo.Models.Booking;
import com.springapp.demo.Services.BookingService;

@RestController
public class BookingController {
    
    @Autowired
    private BookingService bookingService;

    // Add this method to handle the form submission
    @PostMapping("/book-cab")
    public String bookCab(@ModelAttribute Booking booking) {
        // Save the booking data to the database or send it to an external service for processing

        try {
            // Calculate the fare based on the pickup and destination addresses
            bookingService.bookCab(booking.getPickup(), booking.getDestination());
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception
        }

        // Redirect to a confirmation page or display a success message in the current page
        return "redirect:/confirmation";
    }
}

