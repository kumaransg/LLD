package com.mayank.fooddelivery.controllers;

import com.mayank.fooddelivery.model.Restaurant;
import com.mayank.fooddelivery.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping(value = "/restaurant")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRestaurant(@RequestBody final Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
    }

    @GetMapping(value = "/restaurants")
    public List<Restaurant> getAllRestaurant() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping(value = "/restaurant/{restaurantId}")
    public Restaurant getRestaurantById(final String restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }

    @GetMapping(value = "/restaurants/name/{restaurantName}")
    public List<Restaurant> getRestaurantsByName(final String restaurantName) {
        return restaurantService.getRestaurantsByName(restaurantName);
    }

    @GetMapping(value = "/restaurants/city/{city}")
    public List<Restaurant> getRestaurantsByCity(final String city) {
        return restaurantService.getRestaurantsByCity(city);
    }
}
