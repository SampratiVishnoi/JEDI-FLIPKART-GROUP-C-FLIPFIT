package com.flipkart.business;



public class AdminService implements AdminServiceInterface{




    public void approveGymCenter(String gymCentreId,int isApproved){
        System.out.println("Approved/Rejected Gym Center: ");

    }

    public void approveGymOwner(String gymOwnerId,int isApprove){
    }

    public void viewPendingGymCentres(){
        //views all pending requests
        System.out.println("Viewing pending Gym Center Approvals: ");

    }

    public void viewPendingGymOwners(){
        //views all pending requests
        System.out.println("Viewing pending Gym Owner Approvals: ");

    }

}