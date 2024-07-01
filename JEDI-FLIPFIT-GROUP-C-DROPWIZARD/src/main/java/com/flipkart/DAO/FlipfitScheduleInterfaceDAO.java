package com.flipkart.DAO;

import com.flipkart.model.FlipfitSchedule;

import java.sql.Date;
import java.util.List;

public interface FlipfitScheduleInterfaceDAO {
    public void addSchedule(FlipfitSchedule schedule);
    public List<FlipfitSchedule> getAllScheduleByDate(Date date);

}
