package edu.hami.restfulservices.foodsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CUSTOME_DETAILS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    private Customer customer;

}
