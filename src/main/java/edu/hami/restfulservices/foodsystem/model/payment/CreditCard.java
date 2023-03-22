package edu.hami.restfulservices.foodsystem.model.payment;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("credit_card")
public class CreditCard extends PaymentInfo {
    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "CARD_NUMBER")
    private String cardNumber;

    @Column(name = "BANK_NAME")
    private String bankName;
}
