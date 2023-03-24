package edu.hami.restfulservices.foodsystem.repository.person;

import edu.hami.restfulservices.foodsystem.model.person.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
