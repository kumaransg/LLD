package service;

import model.Restaurant;

import java.util.List;

public interface FoodKartRestaurantService {

    // register Restaurant
    void registerRestaurant(String restaurantName, String listOfPincodes, String foodName, double price,
        int quantity);

    boolean updateQuantity(String restaurantName, int quantityToAdd);

    void rateRestaurant(String restaurantName, int rating, String comment);

    List<Restaurant> showRestaurant(String sortBy);

    boolean placeOrder(String restaurantName, int quantity);
}
