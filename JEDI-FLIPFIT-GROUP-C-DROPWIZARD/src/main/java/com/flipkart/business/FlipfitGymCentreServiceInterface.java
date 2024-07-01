package com.flipkart.business;

import com.flipkart.model.FlipfitGymCentre;
import com.flipkart.model.FlipfitGymSlot;

import java.sql.Date;
import java.util.List;

public interface FlipfitGymCentreServiceInterface {

    List<FlipfitGymCentre> getAllCentresByOwmerId(String gymOwnerId);
    List<FlipfitGymCentre> getCentresByCity(String city);
    List<FlipfitGymSlot> getAvailableSlotsByCentreAndDate(String centreID, Date date);
    FlipfitGymCentre addCenter(FlipfitGymCentre gymCentre);
    void requestGymCentreApproval(String gymCentreId);
    FlipfitGymCentre getGymCentreById(String centreID);
    boolean isValdidCentre(String centreID);
}
