package com.flipkart.business;

import com.flipkart.DAO.BookingDAO;
import com.flipkart.bean.Booking;

import com.flipkart.dao.BookingServiceDAOImpl;
import com.flipkart.exceptions.BookingFailedException;
import com.flipkart.utils.UserPlan;

import java.util.Date;
import java.util.List;


public class BookingService implements BookingServiceInterface {

    private final BookingServiceDAOImpl bookingDAO = new BookingServiceDAOImpl();
    //private final ScheduleService scheduleService  = new ScheduleService();

   private final BookingService slotService = new BookingService();

    public boolean checkBookingOverlap(String customerId, Date date, String slotId){
        //return whether the customer has already booked a slot at same timing
        Booking slot = slotService.getSlotByID();
        return bookingDAO.checkBookingOverlap(customerId,date,slot.getTime());
    }
    public void addBooking(String userName, String scheduleID) {
        try {
            boolean isAvailable = scheduleService.modifySchedule(scheduleID,-1);
            if(!isAvailable){
                System.out.println("No seats available for the booking");
                return;
            }
            bookingDAO.addBooking(userName, scheduleID);
        } catch (BookingFailedException e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Booking> getBookingByCustomerId(String customerId){
        try {
            return bookingDAO.getBookingByCustomerId(customerId);
        } catch (BookingFailedException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public List<UserPlan> getCustomerPlan(String customerId){
        return bookingDAO.getCustomerPlan(customerId);
    }

    public void cancelBooking(String bookingID) {
        try {
            Booking booking  = bookingDAO.getBookingByBookingId(bookingID);
            bookingDAO.cancelBookingById(bookingID);
            scheduleService.modifySchedule(booking.getScheduleID(),1);
        } catch (BookingFailedException e) {
            System.out.println(e.getMessage());
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
