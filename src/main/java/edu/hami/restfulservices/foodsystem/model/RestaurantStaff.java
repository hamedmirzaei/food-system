package edu.hami.restfulservices.foodsystem.model;

import edu.hami.restfulservices.foodsystem.model.enums.Position;
import edu.hami.restfulservices.foodsystem.model.person.Staff;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RESTAURANT_STAFFS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Long id;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private Staff staff;

    @Column(name = "POSITION")
    @Enumerated(EnumType.STRING)
    private Position position;
}
