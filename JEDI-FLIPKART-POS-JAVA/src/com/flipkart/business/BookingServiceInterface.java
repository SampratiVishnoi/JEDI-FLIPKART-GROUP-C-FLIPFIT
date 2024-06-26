package com.flipkart.business;

public interface BookingServiceInterface {

    boolean checkBookingOverlap(String customerId, String slotId);
    void addBooking(String userName, String slotId);
    void getBookingByCustomerId(String customerId);
    void cancelBooking(String bookingID);
    void getAllSlotsByCentre(String centreID);
    void getSlotByID(String slotID);
    void getSlotList();
    void addSlotsForGym(String gymCentreId);
    boolean isSlotValid(String slotID,String centreId);
}
