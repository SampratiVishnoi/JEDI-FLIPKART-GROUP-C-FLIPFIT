package com.flipkart.model;

public class FlipfitBooking {


    private String bookingID;
    private String userID;
    private String scheduleID;

    public FlipfitBooking(String userID, String scheduleID) {
        this.userID = userID;
        this.scheduleID = scheduleID;
    }
    public FlipfitBooking(String bookingID,String userID, String scheduleID) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.scheduleID = scheduleID;
    }


    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

}
