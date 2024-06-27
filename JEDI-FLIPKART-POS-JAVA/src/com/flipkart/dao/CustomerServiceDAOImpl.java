package com.flipkart.dao;

import com.flipkart.bean.Customer;

import java.sql.Date;

public class CustomerServiceDAOImpl implements CustomerServiceDAOInterface {

    @Override
    public void getAllGymCenterDetailsByCity(String city) {

    }

    @Override
    public void getAvailableSlots(String centreID, Date date) {

    }

    @Override
    public void getAvailableSlots(String centreID, java.util.Date date) {

    }

    @Override
    public void getCustomerBookings(String customerId) {

    }

    @Override
    public boolean bookSlot(String userID, Date date, String slotId, String centreId) {
        return false;
    }

    @Override
    public void getCustomerPlan(String customerId) {

    }

    @Override
    public boolean bookSlot(String userName, java.util.Date date, String slotId, String centreId) {
        return false;
    }

    @Override
    public void cancelBookingbyID(String bookingID) {

    }

    @Override
    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) {

    }

    @Override
    public Customer viewMyProfile(String userName) {
        return null;
    }

    @Override
    public boolean isUserValid(String userName, String password) {
        return false;
    }
}
