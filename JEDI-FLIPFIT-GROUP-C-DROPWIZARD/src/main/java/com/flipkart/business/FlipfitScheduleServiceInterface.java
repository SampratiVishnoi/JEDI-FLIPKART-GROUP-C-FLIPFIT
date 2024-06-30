package com.flipkart.business;

import com.flipkart.model.FlipfitSchedule;
import com.flipkart.model.FlipfitGymSlot;

import java.sql.Date;
import java.util.List;

public interface FlipfitScheduleServiceInterface {
    FlipfitSchedule createSchedule(Date date, String slotId);
    FlipfitSchedule getScheduleByDateAndSlotId(String SlotId, Date date);
    boolean modifySchedule(String scheduleId,int action);
    List<FlipfitSchedule> checkAvailability(String centreID, Date date);
    List<FlipfitGymSlot> getAllAvailableSlotsByDate(String centreID, Date date);
    FlipfitSchedule getOrCreateSchedule(String slotId, Date date);
}
