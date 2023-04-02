package edu.hami.restfulservices.foodsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.hami.restfulservices.foodsystem.model.enums.RestaurantType;
import edu.hami.restfulservices.foodsystem.model.enums.RestaurantTypeConverter;
import edu.hami.restfulservices.foodsystem.model.menu.MenuItem;
import edu.hami.restfulservices.foodsystem.model.person.Delivery;
import edu.hami.restfulservices.foodsystem.model.person.Staff;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @Convert(converter = RestaurantTypeConverter.class)
    private RestaurantType type;

    @OneToMany(mappedBy = "restaurant")
    @JsonManagedReference
    @JsonIgnore
    private List<Order> orders;

    @OneToMany(mappedBy = "restaurant")
    @JsonManagedReference
    @JsonIgnore
    private List<RestaurantStaff> restaurantStaffs = new ArrayList<>();

    @ManyToMany(mappedBy = "restaurants")
    @JsonManagedReference
    @JsonIgnore
    private List<Delivery> deliveries = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    @JsonManagedReference
    @JsonIgnore
    private List<MenuItem> menuItems;

    public void addOrder(Order order) {
        orders.add(order);
    }
}
