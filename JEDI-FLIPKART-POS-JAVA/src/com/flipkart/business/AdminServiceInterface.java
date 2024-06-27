package com.flipkart.business;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

import java.util.List;


public interface AdminServiceInterface {


    void approveGymCenter(String gymCentreId, int isApproved);


    void approveGymOwner(String gymOwnerId, int isApproved);


    List<GymCentre> viewPendingGymCentres();


    List<GymOwner> viewPendingGymOwners();
}