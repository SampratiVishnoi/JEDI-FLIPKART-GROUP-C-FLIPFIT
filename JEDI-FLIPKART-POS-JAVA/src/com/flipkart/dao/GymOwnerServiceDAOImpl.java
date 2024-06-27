package com.flipkart.dao;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

import java.sql.Date;
import java.util.List;

public class GymOwnerServiceDAOImpl implements GymOwnerServiceDAOInterface {

    @Override
    public void requestGymOwnerApproval(String gymOwnerId) {

    }

    @Override
    public List<GymOwner> viewAllGymOwners() {

    }

    @Override
    public boolean loginGymOwner(String username, String password) {
        return false;
    }

    @Override
    public void registerGymOwner(String userName, String password, String email, String panNumber, String cardNumber, String gstNo) {

    }
}
