package com.springapp.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springapp.demo.DAO.BookingDAO;

@Configuration
public class AppConfiguration {
    
    @Bean
    public DB db() {
        DB db = new DB();
        db.init();
        return db;
    }
    
    @Bean
    public BookingDAO bookingDao(DB db) {
        return new BookingDAO(db);
    }
}
