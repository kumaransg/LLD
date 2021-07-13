package dao;

import Exceptions.RestaurantAlreadyPresent;
import Exceptions.RestaurantNotPresent;
import model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantDao {
    private static RestaurantDao restaurantDaoInstance;
    private HashMap<String, Restaurant> restaurantMap;

    private RestaurantDao() {
        this.restaurantMap = new HashMap<>();
    }

    public static RestaurantDao getInstance() {
        if (restaurantDaoInstance == null)
            restaurantDaoInstance = new RestaurantDao();

        return restaurantDaoInstance;
    }

    public void addRestaurant(Restaurant restaurant) {
        if (this.restaurantMap.containsKey(restaurant.getRestaurantName())) {
            throw new RestaurantAlreadyPresent("restaurant Already present");
        }
        this.restaurantMap.put(restaurant.getRestaurantName(), restaurant);
    }

    public Restaurant getRestaurant(String restaurantName) {
        if (!restaurantMap.containsKey(restaurantName)) {
            throw new RestaurantNotPresent("restaurant Not Present");
        }
        return restaurantMap.get(restaurantName);
    }

    public List<Restaurant> getListOfRestaurants() {
        List<Restaurant> list = new ArrayList<>();
        for (Map.Entry<String, Restaurant> entry : restaurantMap.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}
