package com.flipkart.business;

import com.flipkart.DAO.FlipfitGymCustomerDAO;
import com.flipkart.DAO.FlipfitGymCustomerInterfaceDAO;
import com.flipkart.model.FlipfitBooking;
import com.flipkart.model.FlipfitGymCustomer;
import com.flipkart.model.FlipfitGymCentre;
import com.flipkart.model.FlipfitGymSlot;
import com.flipkart.exceptions.RegistrationFailedException;
import com.flipkart.exceptions.UserInvalidException;
import com.flipkart.utils.UserPlan;

import java.sql.Date;
import java.util.List;

import static com.flipkart.constant.Constants.*;

public class FlipfitGymCustomerService implements FlipfitCustomerServiceInterface {

    private FlipfitGymCustomerInterfaceDAO customerDAO = new FlipfitGymCustomerDAO();
    private FlipfitGymCentreServiceInterface gymCentreService = new FlipfitGymCentreService();
    private FlipfitBookingServiceInterface bookingService = new FlipfitBookingService();
    private FlipfitScheduleServiceInterface scheduleService = new FlipfitScheduleService();

    private FlipfitGymSlotServiceInterface slotService = new FlipfitGymSlotService();

    public List<FlipfitGymCentre> getAllGymCenterDetailsByCity(String city){
        //takes City (Location) as input and returns List<GymCenter>
        return gymCentreService.getCentresByCity(city);
    }

    public List<FlipfitGymSlot> getAvailableSlots(String centreID, Date date){
        //takes centerID and date for input and returns List<Slot>
        return gymCentreService.getAvailableSlotsByCentreAndDate(centreID,date);
    }

    public List<FlipfitBooking> getCustomerBookings(String customerId){
        //takes userId and returns List<Bookings>
        return bookingService.getBookingByCustomerId(customerId);
    }

    public List<UserPlan> getCustomerPlan(String customerId){
        return bookingService.getCustomerPlan(customerId);
    }

    public boolean bookSlot(String userName,Date date, String slotId,String centreId){
        if(!slotService.isSlotValid(slotId,centreId)){
            System.out.println(INVALID_SLOT);
            return false;
        }
        String scheduleId = scheduleService.getOrCreateSchedule(slotId,date).getScheduleID();
        //create booking
        boolean isOverlap = bookingService.checkBookingOverlap(userName,date,slotId);
        if(isOverlap) {
            System.out.println(RED_COLOR + "There exists a conflicting booking, First cancel it!!!!" + RESET_COLOR);
            return false;
        }
        bookingService.addBooking(userName, scheduleId);
        return true;
    }



    public void cancelBookingbyID(String bookingID){
        //cancel a booking
        bookingService.cancelBooking(bookingID);
    }

    public FlipfitGymCustomer registerCustomer(FlipfitGymCustomer customer) {
        try {
            return customerDAO.registerCustomer(customer);
        } catch (RegistrationFailedException e) {
            e.getMessage();
        }
        return null;
    }

    public FlipfitGymCustomer viewMyProfile(String userName) {
        return customerDAO.getCustomerById(userName);
    }

    public boolean isUserValid(String userName, String password) {
        try {
            return customerDAO.isUserValid(userName,password);
        } catch (UserInvalidException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
