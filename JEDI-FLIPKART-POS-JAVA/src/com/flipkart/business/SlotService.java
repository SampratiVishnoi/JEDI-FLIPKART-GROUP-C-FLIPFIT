package com.flipkart.business;


import com.flipkart.bean.Slot;



public class SlotService{

    public void getAllSlotsByCentre(String centreID) {
        System.out.println("Print all Flipfit gym slot list in centre " + centreID);
    }

    public void getSlotByID(String slotID){
        System.out.println("Gives the given slot by ID " + slotID);
    }


    public void getSlotList(){
        System.out.println("Print all Flipfit gym slot list");
    }

    public void addSlotsForGym(String gymCentreId){
        System.out.println("Adding all slots to gym: " + gymCentreId);
    }

    public boolean isSlotValid(String slotID,String centreId){
        return true;
    }
}
