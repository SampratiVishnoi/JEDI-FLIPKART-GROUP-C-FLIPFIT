package com.flipkart.business;

import com.flipkart.DAO.FlipFitGymOwnerDAO;
import com.flipkart.bean.FlipfitGymOwner;

import java.util.List;

public class FlipFitGymOwnerService implements FlipfitGymOwnerServiceInterface {
    private static FlipFitGymOwnerDAO gymOwnerDAO = new FlipFitGymOwnerDAO();
    public void requestGymOwnerApproval(String gymOwnerId) {
        gymOwnerDAO.sendOwnerApprovalRequest(gymOwnerId);

    }

    public List<FlipfitGymOwner> viewAllGymOwners() {
        return gymOwnerDAO.getGymOwnerList();
    }


//    public Object addGymOwnerDetails() {
//        //takes gymOwner object as input
//        return new Object();
//    }

    public boolean loginGymOwner(String username,String password){
        return gymOwnerDAO.loginGymOwner(username,password);
    }

    public void registerGymOwner(String userId,String userName, String password, String email, String panNumber,String cardNumber) {
        gymOwnerDAO.registerGymOwner(new FlipfitGymOwner(userId,userName,email,password,panNumber,cardNumber));
    }
}
