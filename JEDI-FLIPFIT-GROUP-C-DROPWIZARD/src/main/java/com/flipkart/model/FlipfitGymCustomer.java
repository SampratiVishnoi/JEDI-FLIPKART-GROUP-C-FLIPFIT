package com.flipkart.model;

public class FlipfitGymCustomer extends FlipfitUser {

    private String customerPhone;
    private String cardDetails;

    public FlipfitGymCustomer() {
    }

    public FlipfitGymCustomer(String userId, String userName, String email, String password, String customerPhone, String cardDetails) {
        super(userId, userName, email, password, FlipfitRole.CUSTOMER);
        this.customerPhone = customerPhone;
        this.cardDetails = cardDetails;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCardDetails() { return cardDetails; }

    public void setCardDetails(String cardDetails) { this.cardDetails = cardDetails; }

    @Override
    public String toString() {
        return
                super.toString()+
                "customerPhone='" + customerPhone + '\'' +
                ", cardDetails='" + cardDetails ;
    }
}
