package com.flipkart.business;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.flipkart.DAO.FlipFitGymScheduleDAO;
import com.flipkart.bean.FlipfitGymSchedule;
import com.flipkart.bean.FlipfitGymSlot;

public class FlipFitGymScheduleService implements FlipFitGymScheduleServiceInterface {

    private FlipFitGymGymCentreService gymCentreService = new FlipFitGymGymCentreService();
    private FlipFitGymSlotService slotService = new FlipFitGymSlotService();
    private FlipFitGymScheduleDAO scheduleDAO = new FlipFitGymScheduleDAO();

    public FlipfitGymSchedule createSchedule(Date date, String slotId){
        String centreID = slotService.getSlotByID(slotId).getCentreID();
        int availability = gymCentreService.getGymCentreById(centreID).getCapacity();
        FlipfitGymSchedule schedule = new FlipfitGymSchedule( date, slotId, availability);
        scheduleDAO.addSchedule(schedule);

        return schedule;
    }

    public FlipfitGymSchedule getScheduleByDateAndSlotId(String SlotId, Date date){
        //returns whether current schedule exists or not
        List<FlipfitGymSchedule> scheduleList = scheduleDAO.getAllScheduleByDate(date);
        for(FlipfitGymSchedule schedule: scheduleList){
            if(schedule.getSlotID().equals(SlotId))
                return schedule;
        }

        //Schedule doesn't exist, return null
        return null;
    }

    public boolean modifySchedule(String scheduleId,int action){
        // increment or decrement availability based on action
        // 1 for increasing availability, -1 for decreasing
        return scheduleDAO.modifySchedule(scheduleId, action);
    }

    public List<FlipfitGymSchedule> checkAvailability(String centreID, Date date){
        List<FlipfitGymSlot> allSlotsForGym = slotService.getAllSlotsByCentre(centreID);
        List<FlipfitGymSchedule> allAvailableSchedules = new ArrayList<>();
        for(FlipfitGymSlot slot : allSlotsForGym){
            String slotId = slot.getSlotId();
            FlipfitGymSchedule schedule = getOrCreateSchedule(slotId, date);
            if(schedule.getAvailability() > 0)
                allAvailableSchedules.add(schedule);
        }

        return allAvailableSchedules;
    }

    public List<FlipfitGymSlot> getAllAvailableSlotsByDate(String centreID, Date date) {
        List<FlipfitGymSlot> allSlotsOfThatCentre = slotService.getAllSlotsByCentre(centreID);
        List<FlipfitGymSlot> response = slotService.getAllSlotsByCentre(centreID);
        for(FlipfitGymSlot slot: allSlotsOfThatCentre){
            for(FlipfitGymSchedule schedule: scheduleDAO.getAllScheduleByDate(date)){
                if (slotService.getSlotByID(schedule.getSlotID()).getCentreID().equals(centreID)){
                    if(schedule.getAvailability() <= 0){
                        response.remove(slot);
                    }
                }
            }
        }
        return response;
    }

    public FlipfitGymSchedule getSchedule(String scheduleID){
        return scheduleDAO.getSchedule(scheduleID);
    }

    public FlipfitGymSchedule getOrCreateSchedule(String slotId, Date date) {
        FlipfitGymSchedule schedule = getScheduleByDateAndSlotId(slotId, date);
        if( schedule == null ){
            return createSchedule(date,slotId);
        }
        return schedule;

    }
}
