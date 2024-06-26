package com.flipkart.business;



public class GymOwnerService implements GymOwnerServiceInterface {

    public void requestGymOwnerApproval(String gymOwnerId) {
        System.out.println("Owner request added with id: " + gymOwnerId);

    }

    public void viewAllGymOwners() {
        System.out.println("Print all Flipfit gym owners list");

    }

    public boolean loginGymOwner(String username,String password){
        return true;
    }

    public void registerGymOwner(String userId,String userName, String password, String email, String panNumber,String cardNumber, String gstNo) {
        System.out.println("Registratio done successfully");
    }
}
