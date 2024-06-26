package com.flipkart.business;

public interface GymOwnerServiceInterface {
    void requestGymOwnerApproval(String gymOwnerId) ;
    void viewAllGymOwners();
    boolean loginGymOwner(String username,String password);
    void registerGymOwner(String userId,String userName, String password, String email, String panNumber,String cardNumber,String gstNo);
}
