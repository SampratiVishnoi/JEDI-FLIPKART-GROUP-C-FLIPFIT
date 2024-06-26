package com.flipkart.business;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;



public class AdminService {


    public void approveGymCenter(String gymCentreId){

        System.out.println("Approved/Rejected Gym Center: ");

    }

    public void approveGymOwner(String gymOwnerId){
        System.out.println("Approved/Rejected Gym Owner: ");

    }

    public void viewPendingGymCentres(){
        System.out.println("Viewing pending Gym Center Approvals: ");
    }

    public void viewPendingGymOwners(){
        System.out.println("Viewing pending Gym Owner Approvals: ");
    }

}
