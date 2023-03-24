package edu.hami.restfulservices.foodsystem.model.person;

import edu.hami.restfulservices.foodsystem.model.RestaurantStaff;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "SALARY")
    private Double salary;

    @OneToMany(mappedBy = "staff")
    private List<RestaurantStaff> restaurantStaffs = new ArrayList<>();

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", firstName=" + getFirstName() +
                ", lastName=" + getLastName() +
                ", salary=" + salary +
                '}';
    }
}
