package com.springapp.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.demo.Services.CabFareService;

@RestController
public class CabFareController {

    @Autowired
    private CabFareService cabFareService;

    @GetMapping("/cabfare")
    public ResponseEntity<Double> calculateCabFare(
            @RequestParam(name = "pickupAddress") String pickupAddress,
            @RequestParam(name = "destinationAddress") String destinationAddress) throws Exception {

        double fare = cabFareService.calculateFare(pickupAddress, destinationAddress);

        // Return the fare as a response
        return ResponseEntity.ok(fare);
    }
}
