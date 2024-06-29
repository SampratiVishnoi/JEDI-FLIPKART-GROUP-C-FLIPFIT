package com.flipkart.exceptions;

import static com.flipkart.constant.Constants.RED_COLOR;
import static com.flipkart.constant.Constants.RESET_COLOR;

public class FlipFitGymCentreNotFoundException extends RuntimeException{
    public FlipFitGymCentreNotFoundException(String gymId){
        super(RED_COLOR+"Gym Centre" + gymId + " not found!"+RESET_COLOR);
    }
}
