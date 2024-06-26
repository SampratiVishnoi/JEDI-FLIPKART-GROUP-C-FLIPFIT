package com.flipkart.business;

import com.flipkart.bean.GymCentre;

import java.sql.Date;
import java.util.List;

/**
 * This interface defines the service operations related to Gym Centre functionality.
 * It includes methods for retrieving gym centers by owner ID and city, getting available
 * slots by center and date, adding a new gym center, requesting gym center approval,
 * and retrieving gym center details by ID.
 */
public interface GymCentreServiceInterface {


    void getAllCentresByOwnerId(String gymOwnerId);


    void getCentresByCity(String city);

    void getAvailableSlotsByCentreAndDate(String centreID, Date date);


    void addCenter(GymCentre gymCentre);

}