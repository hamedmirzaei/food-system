package edu.hami.restfulservices.foodsystem.model.person;

import edu.hami.restfulservices.foodsystem.model.Order;
import edu.hami.restfulservices.foodsystem.model.payment.PaymentInfo;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer extends PersonInfo {

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, optional = false)
    private CustomerDetails customerDetails;

    @OneToMany(mappedBy = "customer")
    private List<PaymentInfo> paymentInfos;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public void addOrder(Order order) {
        orders.add(order);
    }
}
