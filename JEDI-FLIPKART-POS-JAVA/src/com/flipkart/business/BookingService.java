package com.flipkart.business;

public class BookingService implements BookingServiceInterface{

    public boolean checkBookingOverlap(String customerId, String slotId){
        System.out.println("checkBookingOverlap");
        return true;
    }
    public void addBooking(String userName, String slotId) {
        System.out.println("Booking Added");

    }

    public void getBookingByCustomerId(String customerId){
        System.out.println("Get Booking By Customer Id");

    }


    public void cancelBooking(String bookingID) {
        System.out.println("Cancel booking with ID " + bookingID);

    }
    public void getAllSlotsByCentre(String centreID) {
        System.out.println("Print all Flipfit gym slot list in centre " + centreID);
    }

    public void getSlotByID(String slotID){

        System.out.println("Gives the given slot by ID " + slotID);
    }


    public void getSlotList(){

        System.out.println("Print all Flipfit gym slot list");
    }

    public void addSlotsForGym(String gymCentreId){

        System.out.println("Adding all slots to gym: " + gymCentreId);
    }

    public boolean isSlotValid(String slotID,String centreId){

        return true;
    }
}
