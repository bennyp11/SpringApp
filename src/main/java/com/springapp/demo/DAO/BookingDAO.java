package com.springapp.demo.DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springapp.demo.Config.DB;
import com.springapp.demo.Models.Booking;

@Component 
public class BookingDAO {

    private final String INSERT_BOOKING_SQL = "INSERT INTO cabs.bookings "
            + "(pickup_street_address, pickup_city, pickup_state, pickup_zip_code, destination_street_address, destination_city, destination_state, destination_zip_code, date, time, passengers, fare) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private DB db;
    
    @Autowired
    public BookingDAO(DB db) {
        this.db = db;
    }

	public int saveBooking(Booking booking) {
        int rowsInserted = 0;
        try {
            Connection connection = db.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_BOOKING_SQL, Statement.RETURN_GENERATED_KEYS);

            // Set the parameters for the SQL statement
            statement.setString(1, booking.getPickupStreetAddress());
            statement.setString(2, booking.getPickupCity());
            statement.setString(3, booking.getPickupState());
            statement.setString(4, booking.getPickupZipCode());
            statement.setString(5, booking.getDestinationStreetAddress());
            statement.setString(6, booking.getDestinationCity());
            statement.setString(7, booking.getDestinationState());
            statement.setString(8, booking.getDestinationZipCode());
            statement.setDate(9, java.sql.Date.valueOf(booking.getDate()));
            statement.setTime(10, java.sql.Time.valueOf(booking.getTime()));
            statement.setInt(11, booking.getPassengers());
            statement.setBigDecimal(12, booking.getFare());

            // Execute the SQL statement
            rowsInserted = statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                booking.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted;
    }
}
