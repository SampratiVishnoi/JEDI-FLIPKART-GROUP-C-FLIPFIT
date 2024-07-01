package com.flipkart.DAO;

import com.flipkart.model.FlipfitGymSlot;

import java.time.LocalTime;
import java.util.List;

public interface FlipfitGymSlotInterfaceDAO {
    public List<FlipfitGymSlot> getSlotList();
    public List<FlipfitGymSlot> getSlotByCentreId(String gymCentreId);
    void addSlot(String slotID, String centreID, LocalTime time);
    public FlipfitGymSlot getSlotById(String slotID);
    public FlipfitGymSlot getSlotByIdandCentreId(String slotID, String gymCentreId);
}
