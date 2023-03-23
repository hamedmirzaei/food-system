package edu.hami.restfulservices.foodsystem.model.person;

import edu.hami.restfulservices.foodsystem.model.Restaurant;
import edu.hami.restfulservices.foodsystem.model.enums.Position;
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
public class Staff extends PersonInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "POSITION")
    @Enumerated(EnumType.STRING)
    private Position position;

    @Column(name = "SALARY")
    private Double salary;

    @ManyToMany
    @JoinTable(name = "RESTAURANT_STAFFS",
            joinColumns = @JoinColumn(name = "STAFF_ID"),
            inverseJoinColumns = @JoinColumn(name = "RESTAURANT_ID"))
    private List<Restaurant> restaurants = new ArrayList<>();

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", firstName=" + getFirstName() +
                ", lastName=" + getLastName() +
                ", position=" + position +
                ", salary=" + salary +
                '}';
    }
}
