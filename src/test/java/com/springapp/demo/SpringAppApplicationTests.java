package com.springapp.demo;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.springapp.demo.Controllers.BookingController;
import com.springapp.demo.Models.Booking;

/*
@WebMvcTest(BookingController.class)
public class SpringAppApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testBookCab() throws Exception {

    MockHttpServletRequestBuilder mockRequest = post("/book-cab")
        .param("pickup", "ABC")
        .param("destination", "XYZ")
        .param("date", "2023-03-07")
        .param("time", "10:00")
        .param("passengers", "2");

    mockMvc.perform(mockRequest)
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/confirmation"))
        .andDo(MockMvcResultHandlers.print());

    // Verify that the booking data is printed to the console
    Booking booking = new Booking();
    booking.setPickupCity("ABC");
    booking.setDestinationCity("XYZ");
    booking.setDate(LocalDate.of(2023, 3, 7));
    booking.setTime(LocalTime.of(10, 0));
    booking.setPassengers(2);
    verify(System.out).println("Booking data received:");
    verify(System.out).println("Pickup Location: " + booking.getPickupCity());
    verify(System.out).println("Destination: " + booking.getDestinationCity());
    verify(System.out).println("Date: " + booking.getDate());
    verify(System.out).println("Time: " + booking.getTime());
    verify(System.out).println("Passengers: " + booking.getPassengers());
  }
}
*/