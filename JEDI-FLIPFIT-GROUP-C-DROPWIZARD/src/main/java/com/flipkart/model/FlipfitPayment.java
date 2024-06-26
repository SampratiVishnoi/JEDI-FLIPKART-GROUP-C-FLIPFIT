package com.flipkart.model;

public class FlipfitPayment {

    private String paymentId;
    private String amountPaid;
    private String bookingId;

    public String getPaymentId() { return paymentId; }

    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public String getAmountPaid() { return amountPaid; }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getBookingId() { return bookingId; }

    public void setBookingId(String bookingId) { this.bookingId = bookingId; }
}
