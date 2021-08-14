package com.mayank.fooddelivery.datastore;

import com.mayank.fooddelivery.model.FoodMenu;
import com.mayank.fooddelivery.model.MenuItem;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class FoodMenuData {
    private Map<String, FoodMenu> foodMenuById = new HashMap<>();
    private Map<String, String> foodMenuIdByRestaurantId = new HashMap<>();
    private Map<String, MenuItem> menuItemById = new HashMap<>();
}
