package edu.hami.restfulservices.foodsystem.repository.person;

import edu.hami.restfulservices.foodsystem.model.person.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {
}
