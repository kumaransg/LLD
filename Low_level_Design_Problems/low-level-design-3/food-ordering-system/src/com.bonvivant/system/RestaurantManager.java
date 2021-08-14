package system;

import enums.RestaurantStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exceptions.BonVivantException;
import java.util.stream.Collectors;
import order.Order;
import restaurant.FoodItem;
import restaurant.Restaurant;
import service.RestaurantFinder;
import service.LowestPriceRestaurantStrategy;

public class RestaurantManager {
    private HashMap<String, Restaurant> restaurantMap;
    private HashMap<String, ArrayList<Order>> restaurantOrdersHistory;

    private static RestaurantManager instance = null;

    private RestaurantManager(){
        this.restaurantMap = new HashMap<>();
        this.restaurantOrdersHistory = new HashMap<>();
    }

    public static RestaurantManager getInstance(){
        if(instance == null){
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addRestaunrant(Restaurant restaurant){
        if(restaurantMap.containsKey(restaurant.getName())){
        //    throw new BonVivantException("Restaurant with this name already present. Copyright violation!");
            return;
        }
        restaurantMap.put(restaurant.getName(), restaurant);
        restaurantOrdersHistory.put(restaurant.getName(), new ArrayList<Order>());
    }

    public Restaurant findRestaurant(String name){
        if(restaurantMap.containsKey(name)){
           return restaurantMap.get(name); 
        }
        return null;
    }

    public Restaurant findBy(HashMap<String, Integer> orderedItems) throws BonVivantException {
        // TBD
        Restaurant restaurant = new RestaurantFinder()
            .useStrategy(new LowestPriceRestaurantStrategy())
            .findRestaurant(orderedItems);
        return restaurant;
    }

    public void removeRestaurant(Restaurant restaurant) throws BonVivantException {
        if(restaurantMap.containsKey(restaurant.getName())){
            restaurantMap.remove(restaurant.getName());
            restaurantOrdersHistory.remove(restaurant.getName());
        }

        throw new BonVivantException("Restaurnt not present with this name" + restaurant.getName());
    }

    public ArrayList<Restaurant> getAvailableRestaurants() {
        return restaurantMap.values()
            .stream()
            .filter(x -> x.canAcceptOrder() && x.getStatus() == RestaurantStatus.OPEN)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public List getOrderHistory(Restaurant restaurant){
        if(restaurantMap.containsKey(restaurant.getName())){
            return restaurantOrdersHistory.get(restaurant.getName());
        }
        return null;
    }

    public void placeOrder(Restaurant restaurant, Order order) throws BonVivantException {
        order.setPlacedAt(restaurant.getId());
        if(restaurant.canAcceptOrder()){
            restaurant.addOrders(order);
            restaurantOrdersHistory.get(restaurant.getName()).add(order);
        }
    }
}
