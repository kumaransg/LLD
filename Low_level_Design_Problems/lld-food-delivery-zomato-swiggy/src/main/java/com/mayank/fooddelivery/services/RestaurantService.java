package com.mayank.fooddelivery.services;

import com.mayank.fooddelivery.datastore.RestaurantData;
import com.mayank.fooddelivery.exceptions.ExceptionType;
import com.mayank.fooddelivery.exceptions.FoodDeliveryException;
import com.mayank.fooddelivery.model.Restaurant;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {
    private RestaurantData restaurantData;

    @Autowired
    public RestaurantService(RestaurantData restaurantData) {
        this.restaurantData = restaurantData;
    }

    public void addRestaurant(@NonNull final Restaurant restaurant) {
        if (restaurantData.getRestaurantById().containsKey(restaurant.getId())) {
            throw new FoodDeliveryException(ExceptionType.RESTAURANT_ALREADY_EXISTS, "Duplicate Restaurant");
        }
        restaurantData.getRestaurantById().put(restaurant.getId(), restaurant);

        List<String> restaurantIds = restaurantData.getRestaurantIdsByName()
                .getOrDefault(restaurant.getName(), new ArrayList<>());
        restaurantIds.add(restaurant.getId());
        restaurantData.getRestaurantIdsByName().put(restaurant.getName(), restaurantIds);

        List<String> restaurantsByCity = restaurantData.getRestaurantIdsByCity()
                .getOrDefault(restaurant.getAddress().getCity(), new ArrayList<>());
        restaurantsByCity.add(restaurant.getId());
        restaurantData.getRestaurantIdsByCity().put(restaurant.getAddress().getCity(), restaurantsByCity);
    }

    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(restaurantData.getRestaurantById().values());
    }

    public Restaurant getRestaurantById(@NonNull final String restaurantId) {
        if (!restaurantData.getRestaurantById().containsKey(restaurantId)) {
            throw new FoodDeliveryException(ExceptionType.RESTAURANT_NOT_FOUND, "Restaurant not exists");
        }
        return restaurantData.getRestaurantById().get(restaurantId);
    }

    public List<Restaurant> getRestaurantsByName(@NonNull final String restaurantName) {
        List<Restaurant> restaurants = new ArrayList<>();
        for (String restaurantId : restaurantData.getRestaurantIdsByName().get(restaurantName)) {
            restaurants.add(getRestaurantById(restaurantId));
        }
        return restaurants;
    }

    public List<Restaurant> getRestaurantsByCity(@NonNull final String city) {
        List<Restaurant> restaurants = new ArrayList<>();
        for (String restaurantId : restaurantData.getRestaurantIdsByCity().get(city)) {
            restaurants.add(getRestaurantById(restaurantId));
        }
        return restaurants;
    }
}
