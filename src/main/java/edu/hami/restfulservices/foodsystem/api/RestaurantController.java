package edu.hami.restfulservices.foodsystem.api;

import edu.hami.restfulservices.foodsystem.model.Restaurant;
import edu.hami.restfulservices.foodsystem.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/restaurants")
@Tag(name = "Restaurant API", description = "API for managing restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    @Operation(summary = "Get all restaurants")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All restaurants returned found"),
            @ApiResponse(responseCode = "403", description = "You don't have access to this operation")
    })
    public List<Restaurant> getAll() {
        return restaurantService.findAll();
    }
}
