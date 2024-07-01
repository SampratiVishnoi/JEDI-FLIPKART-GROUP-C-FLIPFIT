package com.flipkart.DAO;

import com.flipkart.model.FlipfitGymCentre;

import java.util.List;

public interface FlipfitGymCentreInterfaceDAO {

    List<FlipfitGymCentre> getAllCentresByOwmerId(String gymOwnerId);
    FlipfitGymCentre getGymCentreByCentreId(String gymCentreId);
    FlipfitGymCentre addGymCentre(FlipfitGymCentre centre);
    public List<FlipfitGymCentre> getPendingGymCentreList();
    public void validateGymCentre(String gymCentreId, int isApproved);
    public void sendCentreApprovalRequest(String gymCentreId);
    public List<FlipfitGymCentre> getGymCentreListByCity(String city);
}
