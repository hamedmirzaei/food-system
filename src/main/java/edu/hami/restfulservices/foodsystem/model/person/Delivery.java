package edu.hami.restfulservices.foodsystem.model.person;

import edu.hami.restfulservices.foodsystem.model.Restaurant;
import edu.hami.restfulservices.foodsystem.model.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DELIVERY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Delivery extends PersonInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "VEHICLE")
    @Enumerated(EnumType.STRING)
    private VehicleType vehicle;

    @Column(name = "SALARY")
    private Double salary;

    @ManyToMany
    @JoinTable(name = "RESTAURANT_DELIVERIES",
            joinColumns = @JoinColumn(name = "DELIVERY_ID"),
            inverseJoinColumns = @JoinColumn(name = "RESTAURANT_ID"))
    private List<Restaurant> restaurants = new ArrayList<>();

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", firstName=" + getFirstName() +
                ", lastName=" + getLastName() +
                ", vehicle=" + vehicle +
                '}';
    }
}
