package com.flipkart.client;

import com.flipkart.bean.Admin;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.AdminService;
import com.flipkart.business.AdminServiceInterface;
import com.flipkart.business.GymOwnerService;
import com.flipkart.business.GymOwnerServiceInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


public class GymFlipFitAdminMenu {

    private static Admin admin = new Admin();
    private static AdminServiceInterface adminService = new AdminService();
    private static GymOwnerServiceInterface gymOwnerService = new GymOwnerService();
    Scanner scanner = new Scanner(System.in);

    public boolean isUserValid(String userName, String password) {
        if (userName.equals(admin.getUserName()) && password.equals(admin.getPassword())) {
            return true;
        }
        return false;
    }

    public boolean adminLogin(String userName, String password) {
//        if (isUserValid(userName, password)) {
//            System.out.println("Successfully logged in");
//
//        }
//        else{
//            System.out.println("Admin Login Failed");
//            return false;
//        }
        adminClientMainPage();
        return true;
    }
    public void adminClientMainPage(){
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currentTime.format(myFormat);
        System.out.println("WELCOME ADMIN!!\nLogin Time: "+currentTime);
        while(true){
            System.out.println("0. View All Gym Owners\n1. View Pending GymOwner Approval Requests\n2. View Pending GymCenter's Approval Requests\n3. Go Back To Previous Menu");
            int pendingChoice = scanner.nextInt();
            switch (pendingChoice) {
                case 0:
                    break;
                case 1:
                    break;

                case 2:
                    break;
                case 3:
                    System.out.println("PREVIOUS_MENU_MESSAGE");
                    return;
                default:
                    System.out.println("INVALID_CHOICE_ERROR");
                    break;
            }
            return;
        }
    }

}
