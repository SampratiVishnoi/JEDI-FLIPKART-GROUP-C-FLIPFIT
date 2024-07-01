package com.flipkart.business;

import com.flipkart.DAO.FlipfitGymSlotDAO;
import com.flipkart.model.FlipfitGymSlot;
import com.flipkart.utils.addSlotDTO;

import java.util.List;

public class FlipfitGymSlotService implements FlipfitGymSlotServiceInterface {
    private static FlipfitGymSlotDAO slotDAO = new FlipfitGymSlotDAO();
    private FlipfitGymCentreServiceInterface gymCentreService = new FlipfitGymCentreService();
    public List<FlipfitGymSlot> getAllSlotsByCentre(String centreID) {
        return slotDAO.getSlotByCentreId(centreID);
    }

    public FlipfitGymSlot getSlotByID(String slotID){
        return slotDAO.getSlotById(slotID);
    }

    public FlipfitGymSlot getSlotByIDandCentreId(String slotID, String centreId){
        return slotDAO.getSlotByIdandCentreId(slotID,centreId);
    }

    public List<FlipfitGymSlot> getSlotList(){
        return slotDAO.getSlotList();
    }

public void addSlotListForGym(String gymCentreId, List<addSlotDTO> slotList) {
    System.out.println("Adding all slots to gym: " + gymCentreId);

    slotList.stream()
            .filter(slot -> !gymCentreService.isValdidCentre(gymCentreId))
            .forEach(slot -> slotDAO.addSlot(slot.getSlotId(), slot.getCentreID(), slot.getTime()));
}


    public boolean isSlotValid(String slotID,String centreId){
        return getSlotByIDandCentreId(slotID,centreId) != null;
    }
}
