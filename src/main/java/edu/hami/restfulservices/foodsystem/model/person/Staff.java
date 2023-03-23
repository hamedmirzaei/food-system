package edu.hami.restfulservices.foodsystem.model.person;

import edu.hami.restfulservices.foodsystem.model.Restaurant;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STAFFS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Staff extends PersonInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "POSITION")
    private String position;

    @Column(name = "SALARY")
    private Float salary;

    @ManyToMany
    @JoinTable(name = "RESTAURANT_STAFFS",
            joinColumns = @JoinColumn(name = "STAFF_ID"),
            inverseJoinColumns = @JoinColumn(name = "RESTAURANT_ID"))
    private List<Restaurant> restaurants = new ArrayList<>();
}
