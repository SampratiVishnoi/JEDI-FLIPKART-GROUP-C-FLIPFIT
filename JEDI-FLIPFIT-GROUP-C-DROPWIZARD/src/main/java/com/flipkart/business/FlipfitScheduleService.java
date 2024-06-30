package com.flipkart.business;

import com.flipkart.DAO.FlipfitScheduleDAO;
import com.flipkart.model.FlipfitSchedule;
import com.flipkart.model.FlipfitGymSlot;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FlipfitScheduleService implements FlipfitScheduleServiceInterface {

    private FlipfitGymCentreService gymCentreService = new FlipfitGymCentreService();
    private FlipfitGymSlotService slotService = new FlipfitGymSlotService();
    private FlipfitScheduleDAO scheduleDAO = new FlipfitScheduleDAO();

    public FlipfitSchedule createSchedule(Date date, String slotId){
        String centreID = slotService.getSlotByID(slotId).getCentreID();
        int availability = gymCentreService.getGymCentreById(centreID).getCapacity();
        FlipfitSchedule schedule = new FlipfitSchedule( date, slotId, availability);
        scheduleDAO.addSchedule(schedule);

        return schedule;
    }

    public FlipfitSchedule getScheduleByDateAndSlotId(String SlotId, Date date) {
        List<FlipfitSchedule> scheduleList = scheduleDAO.getAllScheduleByDate(date);
        return scheduleList.stream()
                .filter(schedule -> schedule.getSlotID().equals(SlotId))
                .findFirst()
                .orElse(null);
    }


    public boolean modifySchedule(String scheduleId,int action){
        // increment or decrement availability based on action
        // 1 for increasing availability, -1 for decreasing
        return scheduleDAO.modifySchedule(scheduleId, action);
    }

    public List<FlipfitSchedule> checkAvailability(String centreID, Date date) {
        List<FlipfitGymSlot> allSlotsForGym = slotService.getAllSlotsByCentre(centreID);
        return allSlotsForGym.stream()
                .map(slot -> getOrCreateSchedule(slot.getSlotId(), date))
                .filter(schedule -> schedule.getAvailability() > 0)
                .collect(Collectors.toList());
    }


    public List<FlipfitGymSlot> getAllAvailableSlotsByDate(String centreID, Date date) {
        List<FlipfitGymSlot> allSlotsOfThatCentre = slotService.getAllSlotsByCentre(centreID);
        return allSlotsOfThatCentre.stream()
                .filter(slot -> scheduleDAO.getAllScheduleByDate(date).stream()
                        .anyMatch(schedule ->
                                slotService.getSlotByID(schedule.getSlotID()).getCentreID().equals(centreID) &&
                                        schedule.getAvailability() > 0
                        )
                )
                .collect(Collectors.toList());
    }


    public FlipfitSchedule getSchedule(String scheduleID){
        return scheduleDAO.getSchedule(scheduleID);
    }

    public FlipfitSchedule getOrCreateSchedule(String slotId, Date date) {
        FlipfitSchedule schedule = getScheduleByDateAndSlotId(slotId, date);
        if( schedule == null ){
            return createSchedule(date,slotId);
        }
        return schedule;

    }
}
