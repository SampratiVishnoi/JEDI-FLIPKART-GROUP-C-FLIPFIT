package com.flipkart.DAO;

import com.flipkart.bean.FlipfitGymSlot;

import java.util.List;

/**
 * This interface defines the data access operations related to Slot functionality.
 * It includes methods for retrieving slot lists, adding slots, and retrieving slots
 * based on center and slot IDs.
 */
public interface FlipFitGymSlotInterfaceDAO {

    /**
     * Retrieves a list of all available slots.
     *
     * @return List of all available slots
     */
    List<FlipfitGymSlot> getSlotList();

    /**
     * Retrieves a list of slots based on the specified gym center ID.
     *
     * @param gymCentreId The ID of the gym center for which slots are retrieved
     * @return List of slots associated with the specified gym center
     */
    List<FlipfitGymSlot> getSlotByCentreId(String gymCentreId);

    /**
     * Adds a new slot to the system.
     *
     * @param slot The Slot object representing the details of the new slot
     */
    void addSlot(FlipfitGymSlot slot);

    /**
     * Retrieves a specific slot based on the provided slot ID.
     *
     * @param slotID The ID of the slot to be retrieved
     * @return Slot object representing the details of the specified slot
     */
    FlipfitGymSlot getSlotById(String slotID);

    /**
     * Retrieves a specific slot based on the provided slot and gym center IDs.
     *
     * @param slotID      The ID of the slot to be retrieved
     * @param gymCentreId The ID of the gym center associated with the slot
     * @return Slot object representing the details of the specified slot and gym center
     */
    FlipfitGymSlot getSlotByIdAndCentreId(String slotID, String gymCentreId);
}
