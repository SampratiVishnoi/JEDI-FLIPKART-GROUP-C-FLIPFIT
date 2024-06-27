package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.GymCentre;

import java.util.List;

public interface GymCentreServiceDAOInterface {
    List<GymCentre> getAllCentresByOwnerId(String gymOwnerId);
    List<GymCentre> getCentresByCity(String city);
    List<Booking> getAvailableSlotsByCentreAndDate(String centreID, java.sql.Date date);
    void addCenter(GymCentre gymCentre);

}
