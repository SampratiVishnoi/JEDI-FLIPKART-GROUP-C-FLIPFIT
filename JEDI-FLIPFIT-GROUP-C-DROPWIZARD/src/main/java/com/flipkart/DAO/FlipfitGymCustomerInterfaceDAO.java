package com.flipkart.DAO;

import com.flipkart.model.FlipfitGymCustomer;
import com.flipkart.exceptions.RegistrationFailedException;
import com.flipkart.exceptions.UserInvalidException;

public interface FlipfitGymCustomerInterfaceDAO {

    FlipfitGymCustomer registerCustomer(FlipfitGymCustomer customer) throws RegistrationFailedException;
    public boolean isUserValid(String userName, String password) throws UserInvalidException;
    FlipfitGymCustomer getCustomerById(String userName);
}
