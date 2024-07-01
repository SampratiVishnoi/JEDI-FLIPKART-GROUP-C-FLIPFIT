package com.flipkart.DAO;

import com.flipkart.model.FlipfitSchedule;
import com.flipkart.constant.SQLConstants;
import com.flipkart.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlipfitScheduleDAO implements FlipfitScheduleInterfaceDAO {

    public void addSchedule( FlipfitSchedule schedule){
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.ADD_SCHEDULE);
            ps.setString(1, schedule.getScheduleID());
            ps.setDate(2, schedule.getDate());
            ps.setString(3, schedule.getSlotID());
            ps.setInt(4, schedule.getAvailability());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public FlipfitSchedule getSchedule(String scheduleId){
        FlipfitSchedule schedule = null;
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_SCHEDULE_BY_ID);
            ps.setString(1, scheduleId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String slotId = rs.getString("slotId");
                int availability = rs.getInt("availability");
                Date date = new Date(rs.getDate("date").getTime());
                schedule = new FlipfitSchedule(date, slotId, availability);
                schedule.setScheduleID(scheduleId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return schedule;
    }

    public List<FlipfitSchedule> getAllScheduleByDate(Date date) {
        ArrayList<FlipfitSchedule> response = new ArrayList<>();
        try{
            Connection conn = DBConnection.connect();
            PreparedStatement ps = conn.prepareStatement(SQLConstants.GET_SCHEDULES_BY_DATE);
            ps.setDate(1, new Date(date.getTime()));
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String scheduleId = rs.getString("scheduleId");
                String slotId = rs.getString("slotId");
                int availability = rs.getInt("availability");
                FlipfitSchedule schedule = new FlipfitSchedule( date, slotId, availability);
                schedule.setScheduleID(scheduleId);
                response.add(schedule);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    public boolean modifySchedule(String scheduleId,int action){
        //1 for increasing, -1 for decreasing
        try{
            Connection conn = DBConnection.connect();
            int availability = getSchedule(scheduleId).getAvailability();
            if(availability < 1 && action == -1){
                return false;
            }
            PreparedStatement ps = conn.prepareStatement(SQLConstants.MODIFY_SCHEDULE_AVAILABILITY);
            ps.setInt(1, availability+action);
            ps.setString(2, scheduleId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
