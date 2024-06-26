package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Slot;

public class BookingService  {

    public boolean checkBookingOverlap(String customerId, String slotId){
        //return whether the customer has already booked a slot at same timing
        System.out.println("checkBookingOverlap");
        return true;
    }
    public void addBooking(String userName, String slotId) {
        // if slot available
        System.out.println("Booking Added");

    }

    public void getBookingByCustomerId(String customerId){
        System.out.println("Get Booking By Customer Id");

    }


    public void cancelBooking(String bookingID) {
        System.out.println("Cancel booking with ID " + bookingID);

    }
}
