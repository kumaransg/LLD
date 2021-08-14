package service;

import enums.ItemStatus;
import enums.RestaurantStatus;
import java.util.ArrayList;
import java.util.HashMap;

import restaurant.FoodItem;
import restaurant.Restaurant;
import system.RestaurantManager;

public class LowestPriceRestaurantStrategy implements IRestaurantSelectionStratgey {

    @Override
    public Restaurant findBy(HashMap<String, Integer> orderedItems) {
        ArrayList<Restaurant> restaurants= RestaurantManager.getInstance().getAvailableRestaurants();
        Restaurant orderFromRestaurant = null;
        Double minPrice = Double.MAX_VALUE;
        for(Restaurant restaurant: restaurants) {
            Boolean hasFoundAll = true;
            Double restaurantPrice = 0.0;
            for(String itemName: orderedItems.keySet()){
                FoodItem orderItem = restaurant.getMenu().findFoodItem(itemName);
                if(orderItem == null){
                    hasFoundAll = false;
                    break;
                }else if(orderItem.getStatus() != ItemStatus.AVAILABLE){
                    hasFoundAll = false;
                    break;
                }
                restaurantPrice += orderItem.getPrice() * orderedItems.get(orderItem.getName());
            }
            if(hasFoundAll && restaurantPrice < minPrice){
                minPrice = restaurantPrice;
                orderFromRestaurant = restaurant;
            }
        }
        return orderFromRestaurant;
    }
}
