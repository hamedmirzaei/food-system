package edu.hami.restfulservices.foodsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "RESTAURANTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;
}