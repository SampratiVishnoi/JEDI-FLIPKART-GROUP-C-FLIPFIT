package com.flipkart.DAO;

import com.flipkart.bean.FlipfitBooking;
import com.flipkart.exceptions.FlipFitBookingFailedException;
import com.flipkart.utils.DBConnection;
import com.flipkart.utils.UserPlan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.flipkart.constant.SQLConstants.*;

public class FlipFitGymBookingDAO {

    public FlipFitGymBookingDAO() {
    }

    FlipFitGymScheduleDAO scheduleDAO  = new FlipFitGymScheduleDAO();

    public void  addBooking(String userName, String scheduleID) throws FlipFitBookingFailedException{
        try {
            //System.out.println(userName + scheduleID);
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(ADD_BOOKING);
            String trimmedBookingId = (userName + scheduleID).substring(0, 36);
            stmt.setString(1, trimmedBookingId);
            stmt.setString(2, userName);
            stmt.setString(3, scheduleID);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException exp) {
            exp.printStackTrace();
            throw new FlipFitBookingFailedException("Booking failed for current slot. Try again later.");
        } catch (Exception exp) {
            System.out.println("Oops! An error occurred. Try again later.");
        }

    }
    public List<FlipfitBooking> getBookingByCustomerId(String customerId) throws FlipFitBookingFailedException {
        List<FlipfitBooking> allBookingList = new ArrayList<>();
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(GET_BOOKING_BY_CUSTOMER_ID);
            stmt.setString(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                FlipfitBooking booking = new FlipfitBooking(
                        rs.getString("bookingId"),
                        rs.getString("userID"),
                        rs.getString("scheduleID")
                );

                allBookingList.add(booking);
            }
        } catch(SQLException sql) {
            throw new FlipFitBookingFailedException("Could not retrieve Bookings by customer id:  " + customerId);
        } catch(Exception e) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
        return allBookingList;
    }

    public List<UserPlan> getCustomerPlan(String customerId) {
        List<UserPlan> allUserPlan = new ArrayList<>();
        List<FlipfitBooking> allBookingList = getBookingByCustomerId(customerId);
        for (FlipfitBooking booking : allBookingList) {
            try {
                Connection conn = DBConnection.connect();
                PreparedStatement stmt = conn.prepareStatement(GET_USERPLAN_BY_CUSTOMER_ID);
                stmt.setString(1, booking.getScheduleID());
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    UserPlan userPlan = new UserPlan(
                            rs.getString("slotId"),
                            rs.getString("centreId"),
                            rs.getTime("time").toLocalTime(),
                            rs.getString("scheduleID"),
                            rs.getDate("date")
                    );

                    allUserPlan.add(userPlan);
                }
            } catch (Exception e) {
                System.out.println("Could not retreive User Plan. Try again later.");
            }
        }
        return allUserPlan;
    }

    public boolean checkBookingOverlap(String customerId, Date date, LocalTime localTime){
        LocalTime endTime = localTime.plusHours(1);

        List<UserPlan> allUserPlan = getCustomerPlan(customerId);
        for(UserPlan userPlan:allUserPlan){

            if(userPlan.getDate().equals(date)){
                if(localTime.compareTo(userPlan.getTime())<=0  && endTime.compareTo(userPlan.getTime())>=0){
                    return true;
                }
                else if(userPlan.getTime().compareTo(localTime)<=0  && userPlan.getTime().compareTo(endTime)>=0)
                    return true;
            }
        }
        return false;
    }


    public void cancelBookingById(String bookingID) throws FlipFitBookingFailedException {
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(CANCEL_BOOKING_BY_ID);
            stmt.setString(1, bookingID);
            stmt.executeUpdate();
        } catch(SQLException sql) {
            throw new FlipFitBookingFailedException("Could not cancel booking for BookingId: " + bookingID);
        } catch(Exception e) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
    }

    public FlipfitBooking getBookingByBookingId(String bookingId) throws FlipFitBookingFailedException{
        FlipfitBooking booking  = null;
        try {
            Connection conn = DBConnection.connect();
            PreparedStatement stmt = conn.prepareStatement(GET_BOOKING_BY_BOOKING_ID);
            stmt.setString(1, bookingId);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                booking = new FlipfitBooking(
                        rs.getString("bookingId"),
                        rs.getString("userID"),
                        rs.getString("scheduleID")
                );

            }
        } catch(SQLException sql) {
            throw new FlipFitBookingFailedException("Could not fetch booking by bookingId: " + bookingId);
        } catch(Exception excep) {
            System.out.println("Oops! An error occurred. Try again later.");
        }
        return booking;
    }
}
