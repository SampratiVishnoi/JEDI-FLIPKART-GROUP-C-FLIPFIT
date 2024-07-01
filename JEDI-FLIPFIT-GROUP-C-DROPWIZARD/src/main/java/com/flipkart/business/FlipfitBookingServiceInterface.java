package com.flipkart.business;

import com.flipkart.model.FlipfitBooking;
import com.flipkart.utils.UserPlan;

import java.util.Date;
import java.util.List;

public interface FlipfitBookingServiceInterface {
    boolean checkBookingOverlap(String customerId, Date date, String slotId);
    void addBooking(String userId, String scheduleID);
    List<FlipfitBooking> getBookingByCustomerId(String customerId);
    void cancelBooking(String bookingID);
    List<UserPlan> getCustomerPlan(String customerId);
}
