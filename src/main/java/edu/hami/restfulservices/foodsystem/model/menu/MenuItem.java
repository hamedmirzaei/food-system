package edu.hami.restfulservices.foodsystem.model.menu;

import edu.hami.restfulservices.foodsystem.model.Restaurant;
import edu.hami.restfulservices.foodsystem.model.person.Customer;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MENU_ITEMS")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    private Restaurant restaurant;
}
