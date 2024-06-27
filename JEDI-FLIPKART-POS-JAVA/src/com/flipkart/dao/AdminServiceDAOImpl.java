package com.flipkart.dao;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.GymCentre;
import java.util.List;

public class AdminServiceDAOImpl implements AdminServiceDAOInterface{
    private static GymOwnerServiceDAOInterface gymOwnerDAO = new GymOwnerServiceDAOImpl();
    private static GymCentreServiceDAOInterface gymCentreDAO = new GymCentreServiceDAOImpl();
    @Override
    public void approveGymCenter(String gymCentreId, int isApproved) {

    }

    @Override
    public void approveGymOwner(String gymOwnerId, int isApproved) {

    }

    @Override
    public List<GymCentre> viewPendingGymCentres() {

    }

    @Override
    public List<GymOwner> viewPendingGymOwners() {
        return gymOwnerDAO.

    }
}
