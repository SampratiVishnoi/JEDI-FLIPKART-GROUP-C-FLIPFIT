package com.flipkart.business;

import com.flipkart.DAO.FlipfitGymCentreDAO;
import com.flipkart.DAO.FlipfitGymCentreInterfaceDAO;
import com.flipkart.model.FlipfitGymCentre;
import com.flipkart.model.FlipfitGymSlot;

import java.sql.Date;
import java.util.List;

public class FlipfitGymCentreService implements FlipfitGymCentreServiceInterface {

    private static FlipfitGymCentreInterfaceDAO gymCentreDAO = new FlipfitGymCentreDAO();
    private static FlipfitScheduleServiceInterface scheduleService = new FlipfitScheduleService();

    public List<FlipfitGymCentre> getAllCentresByOwmerId(String gymOwnerId) {
        return gymCentreDAO.getAllCentresByOwmerId(gymOwnerId);
    }

    public List<FlipfitGymCentre> getCentresByCity(String city){
        return gymCentreDAO.getGymCentreListByCity(city);
    }

    public List<FlipfitGymSlot> getAvailableSlotsByCentreAndDate(String centreID, Date date){
        return scheduleService.getAllAvailableSlotsByDate(centreID, date);
    }

    public FlipfitGymCentre addCenter(FlipfitGymCentre gymCentre) {
        //takes gymCenter details
        return gymCentreDAO.addGymCentre(gymCentre);

    }

    public boolean isValdidCentre(String centreID){
        if(getGymCentreById(centreID) == null) return false;
        return true;

    }

    public void requestGymCentreApproval(String gymCentreId){
        gymCentreDAO.sendCentreApprovalRequest(gymCentreId);
    }

    public FlipfitGymCentre getGymCentreById(String centreID) {
        FlipfitGymCentre gymCentre = gymCentreDAO.getGymCentreByCentreId(centreID);
        return gymCentre;
    }
}
