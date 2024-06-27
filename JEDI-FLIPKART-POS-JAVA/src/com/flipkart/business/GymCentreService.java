package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.GymCentre;
import com.flipkart.dao.GymCentreServiceDAOImpl;
import com.flipkart.dao.GymCentreServiceDAOInterface;

import java.sql.Date;
import java.util.List;

public class GymCentreService implements GymCentreServiceInterface{

    private static GymCentreServiceDAOInterface gymCentreDAO = new GymCentreServiceDAOImpl();
    //private static ScheduleServiceInterface scheduleService = new ScheduleService();

    public List<GymCentre> getAllCentresByOwnerId(String gymOwnerId) {
        return gymCentreDAO.getAllCentresByOwnerId(gymOwnerId);
    }

    public List<GymCentre> getCentresByCity(String city){
        return gymCentreDAO.getCentresByCity(city);
    }

//    public List<Booking> getAvailableSlotsByCentreAndDate(String centreID, Date date){
//        //return scheduleService.getAllAvailableSlotsByDate(centreID, date);
//    }

    public void addCenter(GymCentre gymCentre) {
        //takes gymCenter details
        gymCentreDAO.addCenter(gymCentre);

    }

//    public void requestGymCentreApproval(String gymCentreId){
//        gymCentreDAO.requestGymCentreApproval(gymCentreId);
//    }

//    public GymCentre getGymCentreById(String centreID) {
//        GymCentre gymCentre = gymCentreDAO.getGymCentreById(centreID);
//        return gymCentre;
//    }
}
