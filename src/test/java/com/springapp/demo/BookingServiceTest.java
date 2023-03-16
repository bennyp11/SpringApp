package com.springapp.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springapp.demo.Services.BookingService;
import com.springapp.demo.Services.CabFareService;

public class BookingServiceTest {
    private CabFareService cabFareServiceMock;
    private BookingService bookingService;

    @BeforeEach
    public void setUp() {
        cabFareServiceMock = mock(CabFareService.class);
        bookingService = new BookingService();
        bookingService.setCabFareService(cabFareServiceMock);
    }

    @Test
    public void testBookCab() throws Exception {
        String pickupAddress = "123 Main St";
        String destinationAddress = "456 Oak Ave";
        double fare = 20.0;

        when(cabFareServiceMock.calculateFare(pickupAddress, destinationAddress)).thenReturn(fare);

        double result = bookingService.bookCab(pickupAddress, destinationAddress);

        verify(cabFareServiceMock, times(1)).calculateFare(pickupAddress, destinationAddress);
        assertEquals(fare, result);
    }
}
