package edu.hami.restfulservices.foodsystem.repository;

import edu.hami.restfulservices.foodsystem.model.RestaurantStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantStaffRepository extends JpaRepository<RestaurantStaff, Long> {
}
