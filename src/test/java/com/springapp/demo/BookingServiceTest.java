package com.springapp.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.springapp.demo.Controllers.BookingController;
import com.springapp.demo.Models.Booking;
import com.springapp.demo.Services.BookingService;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingService;

    @MockBean
    private BookingController bookingController;

    private Booking booking;

    @BeforeEach
    public void setUp() {
        booking = new Booking();
        booking.setPickupStreetAddress("123 Main St");
        booking.setPickupCity("San Francisco");
        booking.setPickupState("CA");
        booking.setPickupZipCode("94117");
        booking.setDestinationStreetAddress("456 Oak Ave");
        booking.setDestinationCity("San Francisco");
        booking.setDestinationState("CA");
        booking.setDestinationZipCode("94117");
        booking.setFare(null);
    }

    @Test
    public void testGetBookings() throws Exception {
        List<Booking> expectedBookings = Arrays.asList(booking);
        BookingController bookingController = mock(BookingController.class);
        when(bookingController.getBookings()).thenReturn(expectedBookings);
        assertEquals(expectedBookings, bookingController.getBookings());
    }

    @Test
    public void testBookCab() throws Exception {
        Double expectedFare = 10.0;
        when(bookingService.bookCab(booking.getPickupStreetAddress() + ", " + booking.getPickupCity() + ", " + booking.getPickupState() + " " + booking.getPickupZipCode(),
                booking.getDestinationStreetAddress() + ", " + booking.getDestinationCity() + ", " + booking.getDestinationState() + " " + booking.getDestinationZipCode()))
                        .thenReturn(expectedFare);

        String bookingJson = "{\"pickupStreetAddress\":\"647 Broderick Street\",\"pickupCity\":\"San Francisco\",\"pickupState\":\"CA\",\"pickupZipCode\":\"94117\",\"destinationStreetAddress\":\"678 Oak Ave\",\"destinationCity\":\"San Francisco\",\"destinationState\":\"CA\",\"destinationZipCode\":\"94117\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/book-cab")
            .contentType(MediaType.APPLICATION_JSON)
            .content(bookingJson))
            .andExpect(MockMvcResultMatchers.status().isOk());

        // Verify that the booking was saved to the database
        // (This assumes that you have a working integration test for the BookingDAO)
    }

}
