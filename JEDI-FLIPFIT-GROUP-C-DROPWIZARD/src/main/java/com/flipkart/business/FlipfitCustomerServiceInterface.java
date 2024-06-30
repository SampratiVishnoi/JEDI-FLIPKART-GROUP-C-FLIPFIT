package com.flipkart.business;

import com.flipkart.model.FlipfitBooking;
import com.flipkart.model.FlipfitGymCustomer;
import com.flipkart.model.FlipfitGymCentre;
import com.flipkart.model.FlipfitGymSlot;
import com.flipkart.utils.UserPlan;

import java.sql.Date;
import java.util.List;

public interface FlipfitCustomerServiceInterface {
    List<FlipfitGymCentre> getAllGymCenterDetailsByCity(String city);
    List<FlipfitGymSlot> getAvailableSlots(String centreID, Date date);
    List<FlipfitBooking> getCustomerBookings(String customerId);
    boolean bookSlot(String userID,Date date, String slotId,String centreId);
    void cancelBookingbyID(String bookingID);
    FlipfitGymCustomer registerCustomer(FlipfitGymCustomer customer);
    FlipfitGymCustomer viewMyProfile(String userName);
    boolean isUserValid(String userName, String password);

    List<UserPlan> getCustomerPlan(String userName);
}
