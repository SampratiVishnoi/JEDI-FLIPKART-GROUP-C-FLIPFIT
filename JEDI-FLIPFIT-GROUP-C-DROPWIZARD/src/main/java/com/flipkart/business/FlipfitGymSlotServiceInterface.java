package com.flipkart.business;

import com.flipkart.model.FlipfitGymSlot;
import com.flipkart.utils.addSlotDTO;

import java.util.List;

public interface FlipfitGymSlotServiceInterface {
    List<FlipfitGymSlot> getAllSlotsByCentre(String centreID);
    FlipfitGymSlot getSlotByID(String slotID);
    List<FlipfitGymSlot> getSlotList();
//    void addSlotListForGym(String gymCentreId, List<Slot> slotList);
    void addSlotListForGym(String gymCentreId, List<addSlotDTO> slotList);
    boolean isSlotValid(String slotID,String centreId);
}
