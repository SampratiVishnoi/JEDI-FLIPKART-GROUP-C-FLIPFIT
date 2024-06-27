package com.flipkart.business;

import com.flipkart.bean.GymOwner;

import java.util.List;

public interface GymOwnerServiceInterface {
    void requestGymOwnerApproval(String gymOwnerId) ;
    List<GymOwner> viewAllGymOwners();
    boolean loginGymOwner(String username,String password);
    void registerGymOwner(String userName, String password, String email, String panNumber,String cardNumber,String gstNo);
}
