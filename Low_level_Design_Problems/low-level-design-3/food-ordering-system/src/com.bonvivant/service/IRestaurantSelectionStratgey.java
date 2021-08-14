package service;

import restaurant.Restaurant;

import java.util.HashMap;

public interface IRestaurantSelectionStratgey {
    public Restaurant findBy(HashMap<String, Integer> orderedItems);
}
