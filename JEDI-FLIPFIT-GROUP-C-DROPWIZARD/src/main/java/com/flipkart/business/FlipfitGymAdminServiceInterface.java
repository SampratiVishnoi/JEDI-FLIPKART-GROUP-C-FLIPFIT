package com.flipkart.business;

import com.flipkart.model.FlipfitGymCentre;
import com.flipkart.model.FlipfitGymOwner;

import java.util.List;

public interface FlipfitGymAdminServiceInterface {
    public void approveGymCenter(String gymCentreId,int isApproved);
    void approveGymOwner(String gymOwnerId,int isApprove);
    List<FlipfitGymCentre> viewPendingGymCentres();
    List<FlipfitGymOwner> viewPendingGymOwners();
}
