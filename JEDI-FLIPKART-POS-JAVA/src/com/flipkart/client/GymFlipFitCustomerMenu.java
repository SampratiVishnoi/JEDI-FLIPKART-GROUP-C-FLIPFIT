package com.flipkart.client;

import com.flipkart.bean.Customer;
import com.flipkart.business.CustomerService;
import com.flipkart.business.CustomerServiceInterface;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.flipkart.client.GymFlipFitApplication.scanner;


public class GymFlipFitCustomerMenu {
    private CustomerServiceInterface customerService = new CustomerService();

    public boolean customerLogin(String userName, String password) {
//        Check if credentials are right
//        if (customerService.isUserValid(userName, password)) {
//            LocalDateTime currentTime = LocalDateTime.now();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//            String formattedDateTime = currentTime.format(formatter);
//
//            System.out.println("Successfully logged in at " + formattedDateTime);
//
//        } else {
//            System.out.println("UserName or password doesn't match");
//            return false;
//        }
        customerClientMainPage(userName);
        return true;
    }


    public void register() {
        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Passkey");
        String password = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();


        System.out.println("Enter your Phone Number (10 Digits)");
        String phoneNumber = scanner.next();


        System.out.println("Enter your Card Number (12 Digits)");
        String cardNumber = scanner.next();

        customerService.registerCustomer(userName, password, email, phoneNumber, cardNumber);
        customerClientMainPage(userName);

    }

    public void customerClientMainPage(String userName) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = currentTime.format(myFormat);
        System.out.println("\nWELCOME " + userName + " !!        " + formattedDate + "\nWhat do you want to do");
        while (true) {
            System.out.println("1. View My Profile \n2. Book a slot in a Gym \n3. View Bookings\n4. Cancel Bookings\n5. Go Back to previous menu");
            int choice = scanner.nextInt();
            switch (choice) {
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
