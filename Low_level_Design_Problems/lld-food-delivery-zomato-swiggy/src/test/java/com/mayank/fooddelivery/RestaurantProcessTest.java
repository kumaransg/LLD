package com.mayank.fooddelivery;

import com.mayank.fooddelivery.controllers.RestaurantController;
import com.mayank.fooddelivery.datastore.RestaurantData;
import com.mayank.fooddelivery.services.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RestaurantProcessTest {
    RestaurantController restaurantController;

    @BeforeEach
    void setup() {
        RestaurantService restaurantService = new RestaurantService(new RestaurantData());
        restaurantController = new RestaurantController(restaurantService);
    }

    @Test
    void RestaurantFlowTest() {
        restaurantController.addRestaurant(TestHelper.buildRestaurant("REST1", "Restaurant"));
        restaurantController.addRestaurant(TestHelper.buildRestaurant("REST2", "Restaurant"));
        restaurantController.addRestaurant(TestHelper.buildRestaurant("REST3", "Restaurant 2"));

        System.out.println(restaurantController.getAllRestaurant());

        System.out.println(restaurantController.getRestaurantById("REST2"));

        System.out.println(restaurantController.getRestaurantsByName("Restaurant"));

        System.out.println(restaurantController.getRestaurantsByCity("CITY"));
    }
}
