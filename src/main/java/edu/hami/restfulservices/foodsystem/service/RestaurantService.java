package edu.hami.restfulservices.foodsystem.service;

import edu.hami.restfulservices.foodsystem.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findAll();
}
