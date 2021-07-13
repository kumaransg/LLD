package Util;

import model.Restaurant;
import model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FoodKartUtil {
    public static List<Restaurant> getMatchingRestaurant(List<Restaurant> listOfRestaurants, User currentUser) {
        List<Restaurant> list = new ArrayList<>(listOfRestaurants);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Restaurant restaurant = (Restaurant) iterator.next();
            if (!restaurant.isLocationServiceAble(currentUser.getPincode()) && restaurant.isEnoughQuantityAvailable()) {
                iterator.remove();
            }
        }
        return list;
    }
}
