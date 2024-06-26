package com.flipkart.client;

import com.flipkart.bean.Admin;




public class AdminClient {

    private static Admin admin = new Admin();

    public boolean isUserValid(String userName, String password) {
        if (userName.equals(admin.getUserName()) && password.equals(admin.getPassword())) {
            return true;
        }
        return false;
    }

    public boolean adminLogin(String userName, String password) {
        return true;
    }

    private void handleGymOwnerApprovalRequests(){
            // print the list with indexes from 1
            System.out.println("Admin Approval for a Gym Owner ----------");

    }
    private void handleGymCenterApprovalRequests(){
            // print the list with indexes from 1
            System.out.println("Press 0 to EXIT_MESSAGE or Choose the Gym Centre To Modify:");
    }

    private void printOwnerList(){
        System.out.println("Print all Flipfit gym owner list");
    }

    public void adminClientMainPage(){
                    return;
            }
}
