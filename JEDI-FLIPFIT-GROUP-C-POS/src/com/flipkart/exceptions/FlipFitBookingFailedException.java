package com.flipkart.exceptions;

import static com.flipkart.constant.Constants.RED_COLOR;
import static com.flipkart.constant.Constants.RESET_COLOR;

public class FlipFitBookingFailedException extends RuntimeException{
    public FlipFitBookingFailedException(String message){
        super(RED_COLOR+message+RESET_COLOR);
    }
}
