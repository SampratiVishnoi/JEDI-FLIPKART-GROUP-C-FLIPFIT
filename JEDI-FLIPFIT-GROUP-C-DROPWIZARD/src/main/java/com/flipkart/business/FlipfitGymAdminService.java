package com.flipkart.business;

import com.flipkart.DAO.FlipfitGymAdminDAO;
import com.flipkart.DAO.FlipfitGymAdminInterfaceDAO;
import com.flipkart.DAO.FlipfitGymOwnerDAO;
import com.flipkart.DAO.FlipfitGymOwnerInterfaceDAO;
import com.flipkart.model.FlipfitGymCentre;
import com.flipkart.model.FlipfitGymOwner;

import java.util.ArrayList;
import java.util.List;

public class FlipfitGymAdminService implements FlipfitGymAdminServiceInterface {

    FlipfitGymAdminInterfaceDAO adminDAO  = new FlipfitGymAdminDAO();
    FlipfitGymOwnerInterfaceDAO gymOwnerDAO = new FlipfitGymOwnerDAO();
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
