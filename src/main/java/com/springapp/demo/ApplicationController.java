package com.springapp.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

   @GetMapping("/")
   public String home() {
      return "index"; // This will return the "index.html" template from the "templates" directory
   }
   
   @GetMapping("/bookings")
   public String bookings() {
      return "bookings"; // This will return the "bookings.html" template from the "templates" directory
   }

}
