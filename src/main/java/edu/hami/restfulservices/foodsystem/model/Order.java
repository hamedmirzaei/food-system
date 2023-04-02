package edu.hami.restfulservices.foodsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.hami.restfulservices.foodsystem.model.menu.MenuItem;
import edu.hami.restfulservices.foodsystem.model.person.Customer;
import edu.hami.restfulservices.foodsystem.model.person.Delivery;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "INITIATE_DATE", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    @JsonBackReference
    private Restaurant restaurant;

    @ManyToMany(mappedBy = "orders")
    private List<MenuItem> menuItems = new ArrayList<>();
}
