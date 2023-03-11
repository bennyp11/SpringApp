package com.springapp.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    
    @Autowired
    private CabFareService cabFareService;

    public double bookCab(String pickupAddress, String destinationAddress) throws Exception {
        // Calculate the fare based on the pickup and destination addresses
        double fare = cabFareService.calculateFare(pickupAddress, destinationAddress);

        // Print the fare to the console
        System.out.println("Cab fare: $" + fare);
        
        return fare;
    }
}
