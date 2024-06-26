package com.flipkart.client;

import com.flipkart.bean.Customer;

public class CustomerClient {

    public boolean customerLogin(String userName, String password) {
      // Check if credentials are right
        System.out.println(userName + " " + password);
        return true;
    }


    public void register(){
        System.out.println("Fill all the details");
    }

    private void printSlots(){

        System.out.println("Print all Flipfit gym slots");

    }

    private void chooseSlot(String gymCentreId,String userName,String centreId){
        System.out.println("Choose from the Below Slots");

    }

    private void printUserPlan(String userName){
        System.out.println("Bookings : ");

    }

    private void cancelBookingSubMenu(String userName){

        System.out.println("Select the Booking you want to cancel: ");
        System.out.println("Booking Cancellation Successful");
    }

    public void printCustomerProfile(Customer customer){
        System.out.println("Customer Profile");
    }


    public void customerClientMainPage(String userName) {
        System.out.println("Customer Client Main Page");
    }

}
