package com.flipkart.business;

import com.flipkart.DAO.FlipFitGymBookingDAO;
import com.flipkart.bean.FlipfitBooking;
import com.flipkart.bean.FlipfitGymSlot;
import com.flipkart.exceptions.FlipFitBookingFailedException;
import com.flipkart.utils.UserPlan;

import java.util.Date;
import java.util.List;


public class FlipFitGymBookingService implements FlipFitGymBookingServiceInterface {

    private final FlipFitGymBookingDAO bookingDAO = new FlipFitGymBookingDAO();
    private final FlipFitGymScheduleService scheduleService  = new FlipFitGymScheduleService();

    private final FlipFitGymSlotService slotService = new FlipFitGymSlotService();

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
        } catch (FlipFitBookingFailedException e) {
            System.out.println(e.getMessage());
        }

    }

    public List<FlipfitBooking> getBookingByCustomerId(String customerId){
        try {
            return bookingDAO.getBookingByCustomerId(customerId);
        } catch (FlipFitBookingFailedException e) {
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
        } catch (FlipFitBookingFailedException e) {
            System.out.println(e.getMessage());
        }

    }
}
