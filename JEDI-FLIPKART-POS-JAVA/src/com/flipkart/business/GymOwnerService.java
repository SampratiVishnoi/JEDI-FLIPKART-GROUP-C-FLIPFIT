package com.flipkart.business;



public class GymOwnerService {

    public void requestGymOwnerApproval(String gymOwnerId) {
        System.out.println("Owner request added with id: " + gymOwnerId);

    }

    public void viewAllGymOwners() {
        System.out.println("Print all Flipfit gym owners list");

    }

    public boolean loginGymOwner(String username,String password){
        return true;
    }

    public void registerGymOwner(String userId,String userName, String password, String email, String panNumber,String cardNumber) {
        System.out.println("Registratio done successfully");
    }
}
