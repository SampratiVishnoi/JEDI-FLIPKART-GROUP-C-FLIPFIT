package com.flipkart.business;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;

public class GymCentreService {


    public void getAllCentresByOwnerId(String gymOwnerId) {
        System.out.println("Print all Flipfit gym centre of owner id " + gymOwnerId);
    }

    public void getCentresByCity(String city){
        System.out.println("Print all Flipfit gym centre in city " + city);
    }

    public void getAvailableSlotsByCentreAndDate(String centreID){
        System.out.println("Print all Flipfit gym slots in centre " + centreID);
    }

    public void addCenter(GymCentre gymCentre) {
        //takes gymCenter details
        System.out.println("Flipfit gym centre added");

    }

}
