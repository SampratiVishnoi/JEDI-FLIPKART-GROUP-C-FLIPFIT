package com.flipkart.client;

import com.flipkart.bean.GymCentre;

import com.flipkart.business.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.flipkart.client.GymFlipFitApplication.scanner;

public class GymFlipFitOwnerMenu {

    private GymOwnerServiceInterface gymOwnerService = new GymOwnerService();
    private GymCentreServiceInterface gymCentreService = new GymCentreService();




    public boolean gymOwnerLogin(String userName, String password) {
//        if (gymOwnerService.loginGymOwner(userName,password)) {
//            System.out.println("Successfully logged in");
//
//        } else {
//           System.out.println("Gymowner Login Failed");
//            return false;
//        }
        gymOwnerClientMainPage(userName);
        return true;
    }

    public void register() {
        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Passkey");
        String password = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();

        System.out.println("Enter your PAN Number");
        String panNumber = scanner.next();

        System.out.println("Enter your GST Number");
        String gstNo = scanner.next();

        System.out.println("Enter your Aadhar Card Number");
        String cardNumber = scanner.next();

        gymOwnerService.registerGymOwner(userName,password,email,panNumber,cardNumber,gstNo);
        gymOwnerClientMainPage(userName);
    }



    public void gymOwnerClientMainPage(String gymOwnerId) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currentTime.format(myFormat);
        System.out.println("WELCOME "+gymOwnerId+" !!        "+formattedDate+"\nWhat do you want to do");
        while(true){
            System.out.println("" +
                    "0. View all my Gym Centres\n" +
                    "1. Sending Gym Owner Approval Request\n" +
                    "2. Add a new Gym Center\n" +
                    "3. Send a Gym Centre Approval Request to Admin\n" +
                    "4. Add Slots to a Gym Centre\n" +
                    "5. Go Back to Previous Menu"
            );
            int choice = scanner.nextInt();
            switch (choice){
                /* Take input from user for all service parameters ( Make the menu ) */

                case 0:
                    break;

                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;
                case 5:
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
