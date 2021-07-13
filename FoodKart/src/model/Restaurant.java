package model;

import java.util.*;

public class Restaurant {
    String restaurantId;
    String restaurantName;
    HashSet<String> listOfServicePincode;
    FoodItem foodItem;
    Rating ratings;

    public Restaurant(String restaurantName, String[] listOfServicePincode,
        String foodName, double price, int quantity) {
        this.restaurantId = UUID.randomUUID().toString();
        this.restaurantName = restaurantName;
        this.listOfServicePincode = new HashSet<>(Arrays.asList(listOfServicePincode));
        this.foodItem = new FoodItem(foodName, price, quantity);
        this.ratings = new Rating();
    }

    public void updateQuantity(int quantity) {
        this.foodItem.quantity += quantity;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void addComments(int rating, String comment) {
        ratings.addRatingAndComment(comment, rating);
    }

    public boolean placeOrder(int quantity) {
        if (quantity <= this.foodItem.quantity) {
            this.foodItem.quantity -= quantity;
            return true;
        }
        return false;
    }

    public boolean isLocationServiceAble(String pinCode) {
        return listOfServicePincode.contains(pinCode);
    }

    public boolean isEnoughQuantityAvailable() {
        return this.foodItem.getQuantity() > 0;
    }

    public Double getRestaurantRating() {
        return ratings.getAverageRating();
    }
}
