package com.springapp.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.springapp.demo.Controllers.CabFareController;
import com.springapp.demo.Services.CabFareService;

class CabFareServiceTest {

    @Mock
    private CabFareService cabFareService;
    
    private CabFareController cabFareController;
    
    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        cabFareController = new CabFareController();
        cabFareController.setCabFareService(cabFareService);
    }
    
    @Test
    void testCalculateCabFare() throws Exception {
        String pickupAddress = "123 Main St, Los Angeles, CA";
        String destinationAddress = "456 Oak Ave, Los Angeles, CA";
        double expectedFare = 20.0;
        
        when(cabFareService.calculateFare(anyString(), anyString())).thenReturn(expectedFare);
        
        ResponseEntity<Double> response = cabFareController.calculateCabFare(pickupAddress, destinationAddress);
        
        assertNotNull(response);
        assertNotNull(response.getBody());
    }
    
}
