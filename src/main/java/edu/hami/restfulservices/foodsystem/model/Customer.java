package edu.hami.restfulservices.foodsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CUSTOMERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, optional = false)
    private CustomerDetails customerDetails;
}
