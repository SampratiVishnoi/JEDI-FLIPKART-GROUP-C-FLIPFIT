package com.flipkart.dao;

import com.flipkart.bean.Customer;

import java.util.Date;

public interface CustomerServiceDAOInterface {
    default void getAllGymCenterDetailsByCity(String city){
        //takes City (Location) as input and returns List<GymCenter>
        System.out.println("getAllGymCenterDetailsByCity");
    }


    default void getAvailableSlots(String centreID, java.sql.Date date) {

    }

    void getAvailableSlots(String centreID, Date date);


    void getCustomerBookings(String customerId);


    void getCustomerPlan(String customerId);

    boolean bookSlot(String userName, Date date, String slotId, String centreId);
    void cancelBookingbyID(String bookingID);
    void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber);

}
