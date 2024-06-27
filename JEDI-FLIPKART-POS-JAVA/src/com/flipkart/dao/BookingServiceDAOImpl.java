package com.flipkart.dao;

public class BookingServiceDAOImpl implements BookingServiceDAOInterface{
    @Override
    public boolean checkBookingOverlap(String customerId, String slotId) {
        return false;
    }

    @Override
    public void addBooking(String userName, String slotId) {

    }

    @Override
    public void getBookingByCustomerId(String customerId) {

    }

    @Override
    public void cancelBooking(String bookingID) {

    }

    @Override
    public void getAllSlotsByCentre(String centreID) {

    }

    @Override
    public void getSlotByID(String slotID) {

    }

    @Override
    public void getSlotList() {

    }

    @Override
    public void addSlotsForGym(String gymCentreId) {

    }

    @Override
    public boolean isSlotValid(String slotID, String centreId) {
        return false;
    }
}
