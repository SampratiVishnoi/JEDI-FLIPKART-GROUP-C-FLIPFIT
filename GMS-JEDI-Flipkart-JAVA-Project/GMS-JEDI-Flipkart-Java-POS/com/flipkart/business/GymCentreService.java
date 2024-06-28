package com.flipkart.business;

import com.flipkart.DAO.GymCentreDAO;
import com.flipkart.DAO.GymCentreInterfaceDAO;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;

import java.sql.Date;
import java.util.List;

public class GymCentreService implements GymCentreServiceInterface{

    private static GymCentreInterfaceDAO gymCentreDAO = new GymCentreDAO();
    private static ScheduleServiceInterface scheduleService = new ScheduleService();

    public List<GymCentre> getAllCentresByOwnerId(String gymOwnerId) {
        return gymCentreDAO.getAllCentresByOwnerId(gymOwnerId);
    }

    public List<GymCentre> getCentresByCity(String city){
        return gymCentreDAO.getGymCentreListByCity(city);
    }

    public List<Slot> getAvailableSlotsByCentreAndDate(String centreID, Date date){
        System.out.println("70");
        return scheduleService.getAllAvailableSlotsByDate(centreID, date);
    }

    public void addCenter(GymCentre gymCentre) {
        //takes gymCenter details
        System.out.println("60");
        gymCentreDAO.addGymCentre(gymCentre);

    }

    public void requestGymCentreApproval(String gymCentreId){
        gymCentreDAO.sendCentreApprovalRequest(gymCentreId);
    }

    public GymCentre getGymCentreById(String centreID) {
        GymCentre gymCentre = gymCentreDAO.getGymCentreByCentreId(centreID);
        return gymCentre;
    }
}
