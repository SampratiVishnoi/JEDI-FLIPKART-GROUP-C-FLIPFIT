package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;

import java.util.Date;


public class CustomerService implements CustomerServiceInterface {



    public void getAllGymCenterDetailsByCity(String city){
        //takes City (Location) as input and returns List<GymCenter>
       System.out.println("getAllGymCenterDetailsByCity");
    }

    @Override
    public void getAvailableSlots(String centreID, java.sql.Date date) {

    }

    public void getAvailableSlots(String centreID, Date date){
        //takes centerID and date for input and returns List<Slot>
       System.out.println("getAvailableSlots");
    }

    public void getCustomerBookings(String customerId){
        //takes userId and returns List<Bookings>
        System.out.println("getCustomerBookings");
    }

    @Override
    public boolean bookSlot(String userID, java.sql.Date date, String slotId, String centreId) {
        return false;
    }

    public void getCustomerPlan(String customerId){
        System.out.println("getCustomerPlan");
    }

    public boolean bookSlot(String userName, Date date, String slotId, String centreId){
        System.out.println("Book slot "+slotId);
        return true;
    }



    public void cancelBookingbyID(String bookingID){
        //cancel a booking
        System.out.println("cancelBookingbyID");
    }

    public void registerCustomer(String userName, String password, String email, String phoneNumber, String cardNumber) {
        System.out.println("Customer Registered successfully");
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