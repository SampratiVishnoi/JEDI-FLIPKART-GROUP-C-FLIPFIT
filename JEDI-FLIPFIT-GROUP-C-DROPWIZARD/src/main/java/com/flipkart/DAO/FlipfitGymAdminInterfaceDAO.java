package com.flipkart.DAO;

import com.flipkart.model.FlipfitGymCentre;
import com.flipkart.model.FlipfitGymOwner;

import java.util.List;

public interface FlipfitGymAdminInterfaceDAO {
    public List<FlipfitGymOwner> getPendingGymOwners();
    public void validateGymOwner(String gymOwnerId, int isApproved);
    public void validateGymCentre(String gymCentreId, int isApproved);
    public List<FlipfitGymCentre> getPendingGymCentres();
}
