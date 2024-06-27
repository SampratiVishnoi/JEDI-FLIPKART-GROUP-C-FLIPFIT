package com.flipkart.business;


import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.AdminServiceDAOImpl;
import com.flipkart.dao.AdminServiceDAOInterface;

import java.util.ArrayList;
import java.util.List;

public class AdminService implements AdminServiceInterface{

    AdminServiceDAOInterface adminDAO  = new AdminServiceDAOImpl();

    private List<GymOwner> pendinGymOwnerList = new ArrayList<>();
    private List<GymCentre> pendinGymCentreList = new ArrayList<>();

    public void approveGymCenter(String gymCentreId,int isApproved){
        //takes GymCenter Object as input and return boolean
//        System.out.println("Approved/Rejected Gym Center: ");
        adminDAO.approveGymCenter(gymCentreId,isApproved);
    }

    public void approveGymOwner(String gymOwnerId,int isApprove){
        //takes GymOwner Object as input and return boolean
        adminDAO.approveGymOwner(gymOwnerId,isApprove);
    }

    public List<GymCentre> viewPendingGymCentres(){
        //views all pending requests
        //System.out.println("Viewing pending Gym Center Approvals: ");
        pendinGymCentreList = adminDAO.viewPendingGymCentres();
        return pendinGymCentreList;
    }

    public List<GymOwner> viewPendingGymOwners(){
        //views all pending requests
        System.out.println("Viewing pending Gym Owner Approvals: ");
        pendinGymOwnerList = adminDAO.viewPendingGymOwners();
        return pendinGymOwnerList;
    }

}
