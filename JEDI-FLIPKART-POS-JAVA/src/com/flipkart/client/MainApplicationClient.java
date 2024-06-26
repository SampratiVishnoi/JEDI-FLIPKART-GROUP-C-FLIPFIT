package com.flipkart.client;
import com.flipkart.bean.Role;
import com.flipkart.business.*;

import java.util.Scanner;


public class MainApplicationClient {

    public static void main(String[] args) {
        System.out.println("FLIPFIT GYM");

        AdminServiceInterface adminServiceInterface = new AdminService();
        BookingServiceInterface bookingServiceInterface = new BookingService();
        CustomerServiceInterface customerServiceInterface = new CustomerService();
        GymCentreServiceInterface gymCentreServiceInterface = new GymCentreService();
        GymOwnerServiceInterface gymOwnerServiceInterface = new GymOwnerService();

        

    }
}
