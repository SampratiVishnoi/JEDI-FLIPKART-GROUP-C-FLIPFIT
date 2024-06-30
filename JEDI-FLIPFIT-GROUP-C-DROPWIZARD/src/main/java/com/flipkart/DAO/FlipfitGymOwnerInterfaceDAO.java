package com.flipkart.DAO;

import com.flipkart.model.FlipfitGymOwner;

import java.util.List;

public interface FlipfitGymOwnerInterfaceDAO {

    public List<FlipfitGymOwner> getGymOwnerList();
    public void setGymOwnerList(List<FlipfitGymOwner> gymOwnerList);
    public FlipfitGymOwner registerGymOwner(FlipfitGymOwner gymOwner);
    public List<FlipfitGymOwner> getPendingGymOwnerList();
    public void sendOwnerApprovalRequest(String gymOwnerId);
    public void setPendingGymOwnerList();
    public void validateGymOwner(String gymOwnerId, int isApproved);

}
