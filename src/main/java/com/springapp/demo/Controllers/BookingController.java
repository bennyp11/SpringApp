package com.springapp.demo.Controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.demo.models.Booking;

@RestController
public class BookingController {

   // Add this method to handle the form submission
	@PostMapping("/book-cab")
	public String bookCab(@ModelAttribute Booking booking) {
	    // Save the booking data to the database or send it to an external service for processing

	    // Print the booking data to the console
	    System.out.println("Booking data received:");
	    System.out.println("Pickup Location: " + booking.getPickup());
	    System.out.println("Destination: " + booking.getDestination());
	    System.out.println("Date: " + booking.getDate());
	    System.out.println("Time: " + booking.getTime());
	    System.out.println("Passengers: " + booking.getPassengers());

	    // Redirect to a confirmation page or display a success message in the current page
	    return "redirect:/confirmation";
	}


}
