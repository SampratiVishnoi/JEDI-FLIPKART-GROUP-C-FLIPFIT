package com.flipkart.DAO;

import com.flipkart.bean.FlipfitGymSchedule;

import java.sql.Date;
import java.util.List;

/**
 * This interface defines the data access operations related to Schedule functionality.
 * It includes methods for adding schedules and retrieving schedules by date.
 */
public interface FlipFitGymScheduleInterfaceDAO {

    /**
     * Adds a new schedule to the system.
     *
     * @param schedule The Schedule object representing the details of the new schedule
     */
    void addSchedule(FlipfitGymSchedule schedule);

    /**
     * Retrieves a list of schedules based on the specified date.
     *
     * @param date The date for which schedules are retrieved
     * @return List of schedules on the specified date
     */
    List<FlipfitGymSchedule> getAllScheduleByDate(Date date);
}
