package edu.hami.restfulservices.foodsystem.utils;

import edu.hami.restfulservices.foodsystem.model.Restaurant;
import edu.hami.restfulservices.foodsystem.repository.RestaurantRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final RestaurantRepository restaurantRepository;

    public AppStartupEvent(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Restaurant> restaurants = this.restaurantRepository.findAll();
        restaurants.forEach(System.out::println);
    }
}
