package com.springapp.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;

@Service
public class CabFareService {

    @Autowired
    private GeoApiContext geoApiContext;

    public double calculateFare(String pickupAddress, String destinationAddress) throws Exception {
        // Get the geographic coordinates for the pickup and destination addresses
        GeocodingResult[] pickupResults = GeocodingApi.geocode(geoApiContext, pickupAddress).await();
        LatLng pickupLatLng = pickupResults[0].geometry.location;

        GeocodingResult[] destinationResults = GeocodingApi.geocode(geoApiContext, destinationAddress).await();
        LatLng destinationLatLng = destinationResults[0].geometry.location;

        // Calculate the distance between the pickup and destination points
        DistanceMatrix matrix = DistanceMatrixApi.newRequest(geoApiContext)
                .origins(pickupLatLng)
                .destinations(destinationLatLng)
                .mode(TravelMode.DRIVING)
                .await();

        long meters = matrix.rows[0].elements[0].distance.inMeters;

        // Calculate the fare based on the distance
        double fare = calculateFare(meters);

        return fare;
    }

    private double calculateFare(long meters) {
        // Assuming a fare of $2 per mile
        double miles = meters * 0.000621371;
        return miles * 2;
    }
}
