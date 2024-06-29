package com.flipkart.business;

import com.flipkart.DAO.FlipFitGymAdminDAO;
import com.flipkart.DAO.FlipFitGymAdminInterfaceDAO;
import com.flipkart.bean.FlipfitGymCentre;
import com.flipkart.bean.FlipfitGymOwner;

import java.util.ArrayList;
import java.util.List;

public class FlipfitGymAdminService implements FlipFitGymAdminServiceInterface{

    FlipFitGymAdminInterfaceDAO adminDAO  = new FlipFitGymAdminDAO();

    private List<FlipfitGymOwner> pendinGymOwnerList = new ArrayList<>();
    private List<FlipfitGymCentre> pendinGymCentreList = new ArrayList<>();

    public void approveGymCenter(String gymCentreId,int isApproved){
        //takes GymCenter Object as input and return boolean
//        System.out.println("Approved/Rejected Gym Center: ");
        adminDAO.validateGymCentre(gymCentreId,isApproved);
    }

    public void approveGymOwner(String gymOwnerId,int isApprove){
        //takes GymOwner Object as input and return boolean
        adminDAO.validateGymOwner(gymOwnerId,isApprove);
    }

    public List<FlipfitGymCentre> viewPendingGymCentres(){
        //views all pending requests
        //System.out.println("Viewing pending Gym Center Approvals: ");
        pendinGymCentreList = adminDAO.getPendingGymCentres();
        return pendinGymCentreList;
    }

    public List<FlipfitGymOwner> viewPendingGymOwners(){
        //views all pending requests
        System.out.println("Viewing pending Gym Owner Approvals: ");
        pendinGymOwnerList = adminDAO.getPendingGymOwners();
        return pendinGymOwnerList;
    }

}
