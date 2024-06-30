package com.flipkart.business;

import com.flipkart.model.FlipfitGymOwner;

import java.util.List;

public interface FlipfitGymOwnerServiceInterface {

    void requestGymOwnerApproval(String gymOwnerId);
    List<FlipfitGymOwner> viewAllGymOwners();
    FlipfitGymOwner loginGymOwner(String userId, String password);
    FlipfitGymOwner registerGymOwner(FlipfitGymOwner gymOwner);
}
