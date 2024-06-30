package com.flipkart.DAO;

import com.flipkart.bean.FlipfitGymCentre;
import com.flipkart.bean.FlipfitGymOwner;
import java.util.List;
public class FlipFitGymAdminDAO implements FlipFitGymAdminInterfaceDAO {

    private static FlipFitGymOwnerInterfaceDAO gymOwnerDAO = new FlipFitGymOwnerDAO();
    private static FlipFitGymCentreInterfaceDAO gymCentreDAO = new FlipFitGymCentreDAO();

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
