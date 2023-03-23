package edu.hami.restfulservices.foodsystem.model.payment;

import edu.hami.restfulservices.foodsystem.model.Customer;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PAYMENT_INFO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;
}
