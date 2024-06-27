package com.flipkart.business;


import com.flipkart.bean.GymOwner;
import com.flipkart.dao.GymOwnerServiceDAOImpl;

import java.util.List;

public class GymOwnerService implements GymOwnerServiceInterface {
    private static GymOwnerServiceDAOImpl gymOwnerDAO = new GymOwnerServiceDAOImpl();
    public void requestGymOwnerApproval(String gymOwnerId) {
        gymOwnerDAO.requestGymOwnerApproval(gymOwnerId);

    }

    public List<GymOwner> viewAllGymOwners() {
        return gymOwnerDAO.viewAllGymOwners();
    }


    public boolean loginGymOwner(String username,String password){
        return gymOwnerDAO.loginGymOwner(username,password);
    }

    public void registerGymOwner(String userName, String password, String email, String panNumber,String cardNumber,String gstNo) {
        gymOwnerDAO.registerGymOwner(new GymOwner(userName,email,password,panNumber,cardNumber,gstNo));
    }
}
