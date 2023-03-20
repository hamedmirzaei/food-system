package edu.hami.restfulservices.foodsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "RESTAURANT")
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

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "RATING")
    private Float rating;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
}
