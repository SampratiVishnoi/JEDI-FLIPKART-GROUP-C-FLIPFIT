package com.flipkart.business;

import com.flipkart.DAO.FlipFitGymCentreDAO;
import com.flipkart.DAO.FlipFitGymCentreInterfaceDAO;
import com.flipkart.bean.FlipfitGymCentre;
import com.flipkart.bean.FlipfitGymSlot;

import java.sql.Date;
import java.util.List;

public class FlipFitGymGymCentreService implements FlipfitGymCentreServiceInterface{

    private static FlipFitGymCentreInterfaceDAO gymCentreDAO = new FlipFitGymCentreDAO();
    private static FlipFitGymScheduleServiceInterface scheduleService = new FlipFitGymScheduleService();

    public List<FlipfitGymCentre> getAllCentresByOwnerId(String gymOwnerId) {
        return gymCentreDAO.getAllCentresByOwnerId(gymOwnerId);
    }

    public List<FlipfitGymCentre> getCentresByCity(String city){
        return gymCentreDAO.getGymCentreListByCity(city);
    }

    public List<FlipfitGymSlot> getAvailableSlotsByCentreAndDate(String centreID, Date date){
        return scheduleService.getAllAvailableSlotsByDate(centreID, date);
    }

    public void addCenter(FlipfitGymCentre gymCentre) {
        //takes gymCenter details
        gymCentreDAO.addGymCentre(gymCentre);

    }

    public void requestGymCentreApproval(String gymCentreId){
        gymCentreDAO.sendCentreApprovalRequest(gymCentreId);
    }

    public FlipfitGymCentre getGymCentreById(String centreID) {
        FlipfitGymCentre gymCentre = gymCentreDAO.getGymCentreByCentreId(centreID);
        return gymCentre;
    }
}
