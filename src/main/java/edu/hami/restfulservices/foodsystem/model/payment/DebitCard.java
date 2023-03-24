package edu.hami.restfulservices.foodsystem.model.payment;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("debit_card")
@Getter
@Setter
public class DebitCard extends PaymentInfo {
    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "CARD_NUMBER")
    private String cardNumber;
}
