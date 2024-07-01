package com.flipkart.business;

import com.flipkart.DAO.FlipFitGymSlotDAO;
import com.flipkart.bean.FlipfitGymSlot;

import java.util.List;

public class FlipFitGymSlotService implements FlipFitGymSlotServiceInterface {
    private static FlipFitGymSlotDAO slotDAO = new FlipFitGymSlotDAO();
    public List<FlipfitGymSlot> getAllSlotsByCentre(String centreID) {
        return slotDAO.getSlotByCentreId(centreID);
    }

    public FlipfitGymSlot getSlotByID(String slotID){
        return slotDAO.getSlotById(slotID);
    }

    public FlipfitGymSlot getSlotByIDAndCentreId(String slotID, String centreId){
        return slotDAO.getSlotByIdAndCentreId(slotID,centreId);
    }

    public List<FlipfitGymSlot> getSlotList(){
        return slotDAO.getSlotList();
    }

    public void addSlotsForGym(String gymCentreId, List<FlipfitGymSlot> slotList){
        System.out.println("Adding all slots to gym: " + gymCentreId);
        for(FlipfitGymSlot slot : slotList) {
            slot.setCentreID(gymCentreId);
            slotDAO.addSlot(slot);
        }
    }

    public boolean isSlotValid(String slotID,String centreId){
        return getSlotByIDAndCentreId(slotID,centreId) != null;
    }
}
