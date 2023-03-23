package edu.hami.restfulservices.foodsystem.model.person;

import jakarta.persistence.*;
import lombok.*;

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
}
