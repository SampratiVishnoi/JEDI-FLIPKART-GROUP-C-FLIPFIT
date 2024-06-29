package com.flipkart.exceptions;

import static com.flipkart.constant.Constants.RED_COLOR;
import static com.flipkart.constant.Constants.RESET_COLOR;

public class FlipFitGymOwnerNotFoundException extends Exception {
    public FlipFitGymOwnerNotFoundException(String gymOwnerId){
        super(RED_COLOR+"Gym Owner with ID: " + gymOwnerId + " does not exist."+RESET_COLOR);
    }
}
