package com.flipkart.client;

import com.flipkart.bean.Role;

import java.util.Scanner;


public class GymFlipFitApplication {

    // public static int userId = 0;
    public static Scanner scanner = new Scanner(System.in);
    private static GymFlipFitAdminMenu adminClient = new GymFlipFitAdminMenu();
    private static GymFlipFitCustomerMenu customerClient = new GymFlipFitCustomerMenu();
    private static GymFlipFitOwnerMenu gymOwnerClient = new GymFlipFitOwnerMenu();


    private static void mainPage() {
        System.out.println("1. Login\n2. Registration\n3. Change Password\n4. Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                registration();
                break;
            case 3:
                changepassword();
                break;
            case 4:
                System.out.println("EXIT_MESSAGE");
                return;
            default:
                System.out.println("INVALID_CHOICE_ERROR");
                break;
        }
        //mainPage();
    }

    private static void login() {
        System.out.println("Enter your Role (ADMIN/GYMOWNER/CUSTOMER) : ");
        Role role = Role.valueOf(scanner.next().toUpperCase());

        System.out.println("Enter your UserName : ");
        String userName = scanner.next();

        System.out.println("Enter your Passkey :");
        String password = scanner.next();

        switch (role) {
            case ADMIN:
                adminClient.adminLogin(userName, password);
                break;
            case GYMOWNER:
                gymOwnerClient.gymOwnerLogin(userName, password);
                break;
            case CUSTOMER:
                customerClient.customerLogin(userName, password);
                break;
            default:
                System.out.println("INVALID_CHOICE_ERROR");
                break;
        }
    }

    private static void registration() {

        System.out.println("Enter your role (ADMIN/GYMOWNER/CUSTOMER) : ");
        Role role = Role.valueOf(scanner.next().toUpperCase());

        switch (role) {
            case ADMIN:
                System.out.println("Admin is already registered");
                mainPage();
                break;
            case CUSTOMER:
                customerClient.register();
                break;
            case GYMOWNER:
                gymOwnerClient.register();
                break;
            default:
                System.out.println("INVALID_CHOICE_ERROR");
                break;
        }
    }

    private static void changepassword() {

        System.out.println("Enter your old password : ");
        String oldPassword = scanner.next();
        System.out.println("Enter your new password : ");
        String newPassword = scanner.next();
        login();
    }

    public static void main(String[] args) {
        System.out.println("WELCOME TO FLIPFIT GYM");
        mainPage();
    }
}
