package com.springapp.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.demo.models.Booking;

@RestController
public class BookingController {

   // Remove this method since it's not needed
   // @GetMapping("/bookings")
   // public String getBookings() {
   //    // This method should return the booking data in a format that can be displayed in the HTML template
   //    return "Booking data 123456789";
   // }
   
   // Add this method to handle the form submission
	@PostMapping("/book-cab")
	public String bookCab(@ModelAttribute Booking booking) {
	    // Save the booking data to the database or send it to an external service for processing
	    // Redirect to a confirmation page or display a success message in the current page
	    return "redirect:/confirmation";
	}

}
