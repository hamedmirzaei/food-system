package edu.hami.restfulservices.foodsystem.model.person;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PERSON_INFOS")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class PersonInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
}
