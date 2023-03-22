package edu.hami.restfulservices.foodsystem.repository.menu;

import edu.hami.restfulservices.foodsystem.model.menu.MenuItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {
}
