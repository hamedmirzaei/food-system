package edu.hami.restfulservices.foodsystem.repository.person;

import edu.hami.restfulservices.foodsystem.model.person.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonInfoRepository extends JpaRepository<PersonInfo, Long> {
}
