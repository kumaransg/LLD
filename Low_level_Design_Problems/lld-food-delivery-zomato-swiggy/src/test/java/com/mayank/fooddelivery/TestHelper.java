package com.mayank.fooddelivery;

import com.mayank.fooddelivery.model.*;
import org.mockito.internal.matchers.Or;

public class TestHelper {
    public static Restaurant buildRestaurant(String id, String name) {
        return Restaurant.builder()
                .id(id)
                .name(name)
                .address(buildAddress("ADD1", "CITY"))
                .build();
    }

    public static Address buildAddress(String id, String city) {
        return Address.builder()
                .id(id)
                .city(city)
                .build();
    }

    public static MenuItem buildMenuItem(String id, String name, double price) {
        return MenuItem.builder()
                .id(id)
                .itemName(name)
                .cuisineType(CuisineType.ITALIAN_CUISINE)
                .mealType(MealType.DINNER)
                .price(price)
                .build();
    }

    public static User buildUser(String id, String name) {
        return User.builder()
                .id(id)
                .name(name)
                .phoneNo(9988998899L)
                .address(buildAddress("ADD1", "CITY1"))
                .build();
    }
}
