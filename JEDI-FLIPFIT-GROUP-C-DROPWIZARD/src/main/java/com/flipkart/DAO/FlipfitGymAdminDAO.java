package com.flipkart.DAO;

import com.flipkart.model.FlipfitGymCentre;
import com.flipkart.model.FlipfitGymOwner;

import java.util.List;
public class FlipfitGymAdminDAO implements FlipfitGymAdminInterfaceDAO {

    private static FlipfitGymOwnerInterfaceDAO gymOwnerDAO = new FlipfitGymOwnerDAO();
    private static FlipfitGymCentreInterfaceDAO gymCentreDAO = new FlipfitGymCentreDAO();


    public List<FlipfitGymOwner> getPendingGymOwners() {
        return gymOwnerDAO.getPendingGymOwnerList();
    }

    public void validateGymOwner(String gymOwnerId, int isApproved) {
        gymOwnerDAO.validateGymOwner(gymOwnerId, isApproved);
    }

    public void validateGymCentre(String gymCentreId, int isApproved) {
        gymCentreDAO.validateGymCentre(gymCentreId,isApproved);
    }

    public List<FlipfitGymCentre> getPendingGymCentres() {
        return gymCentreDAO.getPendingGymCentreList();
    }




}
