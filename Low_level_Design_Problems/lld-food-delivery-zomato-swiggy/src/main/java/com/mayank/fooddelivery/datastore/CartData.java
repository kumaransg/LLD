package com.mayank.fooddelivery.datastore;

import com.mayank.fooddelivery.exceptions.ExceptionType;
import com.mayank.fooddelivery.exceptions.FoodDeliveryException;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Getter
public class CartData {
    private Map<String, Map<String, List<String>>> userToRestaurantIdToMenuItemIds = new HashMap<>();

    public List<String> getMenuItemIds(@NonNull final String userId, @NonNull final String restaurantId) {
        Map<String, List<String>> restaurantIdToMenuItemIds = getRestaurantIdToMenuItemIds(userId);
        if (!restaurantIdToMenuItemIds.containsKey(restaurantId)) {
            throw new FoodDeliveryException(ExceptionType.CART_IS_EMPTY, "Cart is empty for this restaurant");
        }
        return restaurantIdToMenuItemIds.get(restaurantId);
    }

    public Map<String, List<String>> getRestaurantIdToMenuItemIds(@NonNull final String userId) {
        return userToRestaurantIdToMenuItemIds.getOrDefault(userId, new HashMap<>());
    }
}
