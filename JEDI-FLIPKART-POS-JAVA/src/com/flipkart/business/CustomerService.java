package com.flipkart.business;

public class CustomerService  {

    public void getAllGymCenterDetailsByCity(String city){
        System.out.println("Print all Flipfit gym centre");
    }

    public void getAvailableSlots(String centreID){
        System.out.println("Print all Flipfit gym slots");
    }

    public void getCustomerBookings(String customerId){
        System.out.println("Get all bookings of Customer "+customerId);
    }


    public boolean bookSlot(String userName, String slotId,String centreId){
        System.out.println("Book slot "+slotId);
        return true;
    }



    public void cancelBookingbyID(String bookingID){
        //cancel a booking
        System.out.println("Cancel Booking "+bookingID);
    }

    public void registerCustomer(String userName, String password, String email, String phoneNumber, String address) {
       System.out.println("Customer Registered successfully");

    }



}
