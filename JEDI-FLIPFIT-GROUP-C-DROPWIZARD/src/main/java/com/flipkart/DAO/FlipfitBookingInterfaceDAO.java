package com.flipkart.DAO;

import com.flipkart.model.FlipfitBooking;

import java.util.List;

public interface FlipfitBookingInterfaceDAO {
    void  addBooking(String userName, String scheduleID);
    List<FlipfitBooking> getBookingByCustomerId(String customerId);
    void cancelBookingById(String bookingID);
}
