package com.flipkart.DAO;

import com.flipkart.bean.FlipfitGymSlot;
import com.flipkart.constant.SQLConstants;
import com.flipkart.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FlipFitGymSlotDAO implements FlipFitGymSlotInterfaceDAO {
    public FlipFitGymSlotDAO(){
    }

    public List<FlipfitGymSlot> getSlotList() {
        List<FlipfitGymSlot> slotList = new ArrayList<>();
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_ALL_SLOTS);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String slotId = rs.getString("slotId");
                String centreId = rs.getString("centreId");
                LocalTime time = rs.getTime("time").toLocalTime();

                slotList.add(new FlipfitGymSlot(slotId, centreId, time));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return slotList;
    }

    public List<FlipfitGymSlot> getSlotByCentreId(String gymCentreId){
        List<FlipfitGymSlot> slotList = new ArrayList<>();
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_SLOT_BY_CENTRE);
            ps.setString(1,gymCentreId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String slotId = rs.getString("slotId");
                String centreId = rs.getString("centreId");
                LocalTime time = rs.getTime("time").toLocalTime();

                slotList.add(new FlipfitGymSlot(slotId, centreId, time));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return slotList;
    }

    public void addSlot(FlipfitGymSlot slot){
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.ADD_SLOT);
            ps.setString(1, slot.getSlotId());
            ps.setString(2, slot.getCentreID());
            ps.setTime(3, java.sql.Time.valueOf(slot.getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public FlipfitGymSlot getSlotById(String slotID) {
        FlipfitGymSlot slot = null;
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_SLOT_BY_ID);
            ps.setString(1,slotID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String centreId = rs.getString("centreId");
                LocalTime time = rs.getTime("time").toLocalTime();
                slot = new FlipfitGymSlot(slotID, centreId, time);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return slot;
    }

    public FlipfitGymSlot getSlotByIdAndCentreId(String slotID,String centreID) {
        FlipfitGymSlot slot = null;
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.FETCH_SLOT_BY_ID_AND_CENTRE_ID);
            ps.setString(1,slotID);
            ps.setString(2,centreID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LocalTime time = rs.getTime("time").toLocalTime();
                slot = new FlipfitGymSlot(slotID, centreID, time);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return slot;
    }
}
