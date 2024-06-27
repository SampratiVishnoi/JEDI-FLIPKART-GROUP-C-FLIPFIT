package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.GymCentre;

import java.util.List;

public class GymCentreServiceDAOImpl implements GymCentreServiceDAOInterface {
    public List<GymCentre> getAllCentresByOwnerId(String gymOwnerId) {
        System.out.println("Print all Flipfit gym centre of owner id " + gymOwnerId);

    }

    public List<GymCentre> getCentresByCity(String city){
        System.out.println("Print all Flipfit gym centre in city " + city);
    }


    public List<Booking> getAvailableSlotsByCentreAndDate(String centreID, java.sql.Date date) {
        System.out.println("Print all Flipfit gym slots in centre " + centreID);
    }

    public void addCenter(GymCentre gymCentre) {
        //takes gymCenter details
        System.out.println("Flipfit gym centre added");

    }

}
