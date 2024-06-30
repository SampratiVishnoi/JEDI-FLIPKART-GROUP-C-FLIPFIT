package com.flipkart.client;

import com.flipkart.bean.FlipfitGymCentre;
import com.flipkart.bean.FlipfitGymSlot;
import com.flipkart.DAO.FlipFitGymOwnerDAO;
import com.flipkart.business.*;
import com.flipkart.exceptions.LoginFailedException;
import com.flipkart.utils.util;

import java.time.LocalDateTime;
import java.time.LocalTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.flipkart.client.FlipFitGymApplicationClient.scanner;
import static com.flipkart.constant.Constants.*;

public class FlipFitGymOwnerClient {

    FlipFitGymOwnerDAO gymOwnerDAO = new FlipFitGymOwnerDAO();
    //private List<GymOwner> gymOwnerList = gymOwnerDAO.getGymOwnerList();
    private FlipfitGymOwnerServiceInterface gymOwnerService = new FlipFitGymOwnerService();
    private FlipFitGymSlotServiceInterface slotService = new FlipFitGymSlotService();
    private FlipfitGymCentreServiceInterface gymCentreService = new FlipFitGymGymCentreService();




    public boolean gymOwnerLogin(String userName, String password) {
        if (gymOwnerService.loginGymOwner(userName,password)) {
            System.out.println("Successfully logged in");
            gymOwnerClientMainPage(userName);
        } else {
            new LoginFailedException("Gymowner Login Failed");
            return false;
        }
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

        System.out.println("Enter your Card Number");
        String cardNumber = scanner.next();

        gymOwnerService.registerGymOwner(userName,userName,password,email,panNumber,cardNumber);
        gymOwnerClientMainPage(userName);
    }



    public void gymOwnerClientMainPage(String gymOwnerId) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currentTime.format(myFormat);
        System.out.println(YELLOW_COLOR+"WELCOME "+gymOwnerId+" !!        "+formattedDate+"\nWhat do you want to do"+RESET_COLOR);
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
                    List<FlipfitGymCentre> allGymCentres = gymCentreService.getAllCentresByOwnerId(gymOwnerId);
                    util.printGymCentres(allGymCentres);
                    break;

                case 1:
                    gymOwnerService.requestGymOwnerApproval(gymOwnerId);
                    break;

                case 2:

                    System.out.println("Enter gym centre id: ");
                    String gymId = scanner.next();

                    System.out.println("Enter Gym Centre name: ");
                    String gymCentreName = scanner.next();

                    System.out.println("Enter Gym Centre GSTIN: ");
                    String gstin = scanner.next();

                    System.out.println("Enter Gym Centre city: ");
                    String city = scanner.next();

                    System.out.println("Enter Gym Centre capacity: ");
                    int capacity = scanner.nextInt();

                    System.out.println("Enter price: ");
                    int price = scanner.nextInt();

                    gymCentreService.addCenter(
                            new FlipfitGymCentre(
                                    gymId,
                                    gymOwnerId,
                                    gymCentreName,
                                    gstin,
                                    city,
                                    capacity,
                                    price
                            )
                    );
                    break;

                case 3:

                    System.out.println("Enter Gym Centre Id: ");
                    String gymCentreId = scanner.next();

                    gymCentreService.requestGymCentreApproval(gymCentreId);
                    break;

                case 4:

                    boolean isAdding = true;
                    String centreId = null;

                    List<FlipfitGymSlot> newSlotList = new ArrayList<>();
                    while (isAdding) {
                        System.out.println("Enter new slot id: ");
                        String slotId = scanner.next();

                        System.out.println("Enter Gym Centre Id: ");
                        centreId = scanner.next();

                        System.out.println("Enter time in 24h format (hh:mm:ss) : ");
                        String time = scanner.next();

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                        LocalTime localTime = LocalTime.parse(time, formatter);

                        newSlotList.add(new FlipfitGymSlot(
                                slotId,
                                centreId,
                                localTime
                        ));

                        System.out.println("Do you want to enter more slots (y/n)?: ");
                        String addChoice = scanner.next();
                        addChoice = addChoice.toLowerCase();

                        if(addChoice.equals("n") || addChoice.equals("no")) {
                            isAdding = false;
                        }
                    }

                    slotService.addSlotsForGym(centreId, newSlotList);
                    break;
                case 5:
                    System.out.println(PREVIOUS_MENU_MESSAGE);
                    return;
                default:
                    System.out.println(INVALID_CHOICE_ERROR);
                    break;
            }
        }
    }



}
