package com.flipkart.business;

import com.flipkart.DAO.FlipfitBookingDAO;
import com.flipkart.model.FlipfitBooking;
import com.flipkart.model.FlipfitGymSlot;
import com.flipkart.exceptions.BookingFailedException;
import com.flipkart.utils.UserPlan;

import java.util.Date;
import java.util.List;


public class FlipfitBookingService implements FlipfitBookingServiceInterface {

    private final FlipfitBookingDAO bookingDAO = new FlipfitBookingDAO();
    private final FlipfitScheduleService scheduleService  = new FlipfitScheduleService();

    private final FlipfitGymSlotService slotService = new FlipfitGymSlotService();

    public boolean checkBookingOverlap(String customerId, Date date, String slotId){
        //return whether the customer has already booked a slot at same timing
        FlipfitGymSlot slot = slotService.getSlotByID(slotId);
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

    public List<FlipfitBooking> getBookingByCustomerId(String customerId){
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
            FlipfitBooking booking  = bookingDAO.getBookingByBookingId(bookingID);
            bookingDAO.cancelBookingById(bookingID);
            scheduleService.modifySchedule(booking.getScheduleID(),1);
        } catch (BookingFailedException e) {
            System.out.println(e.getMessage());
        }

    }
}
