package service;

import restaurant.Restaurant;

import java.util.HashMap;

import exceptions.BonVivantException;
import restaurant.FoodItem;

public class RestaurantFinder {
    private IRestaurantSelectionStratgey _restaurantSelectionStratgey;
    
    public RestaurantFinder(){
    }

    public RestaurantFinder useStrategy(IRestaurantSelectionStratgey stratgey){
        _restaurantSelectionStratgey = stratgey;
        return this;
    }

    public Restaurant findRestaurant(HashMap<String, Integer> orderedItems)
        throws BonVivantException {
        if(_restaurantSelectionStratgey == null){
            throw new BonVivantException("IRestaurantSelectionStratgey strategy is not set.");
        }
        return _restaurantSelectionStratgey.findBy(orderedItems);
    }
}
