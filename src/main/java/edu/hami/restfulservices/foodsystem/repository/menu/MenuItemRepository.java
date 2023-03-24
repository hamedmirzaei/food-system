package edu.hami.restfulservices.foodsystem.repository.menu;

import edu.hami.restfulservices.foodsystem.model.menu.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    @Query("SELECT m FROM MAIN_MEALS m")
    List<MainMeal> findAllMainMeals();

    @Query("SELECT m FROM APPETIZERS m")
    List<Appetizer> findAllAppetizers();

    @Query("SELECT m FROM DRINKS m")
    List<Drink> findAllDrinks();

    @Query("SELECT m FROM SIDES m")
    List<Side> findAllSides();
}
