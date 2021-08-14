package com.mayank.fooddelivery.services;

import com.mayank.fooddelivery.commands.CartCommandExecutor;
import com.mayank.fooddelivery.datastore.CartData;
import com.mayank.fooddelivery.model.CartCommandType;
import com.mayank.fooddelivery.model.MenuItem;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {
    private CartData cartData;
    private List<CartCommandExecutor> cartCommandExecutorList;
    private FoodMenuService foodMenuService;

    @Autowired
    public CartService(CartData cartData, List<CartCommandExecutor> cartCommandExecutorList,
                       FoodMenuService foodMenuService) {
        this.cartData = cartData;
        this.cartCommandExecutorList = cartCommandExecutorList;
        this.foodMenuService = foodMenuService;
    }

    public void clearCart(@NonNull final String userId, @NonNull final String restaurantId) {
        Map<String, List<String>> restaurantIdToMenuItemIds = cartData.getUserToRestaurantIdToMenuItemIds()
                .getOrDefault(userId, new HashMap<>());
        restaurantIdToMenuItemIds.put(restaurantId, new ArrayList<>());
    }

    public void updateCart(@NonNull final String userId, @NonNull final String restaurantId,
                           @NonNull final String itemId, @NonNull final CartCommandType cartCommandType) {
        for (CartCommandExecutor cartCommandExecutor : cartCommandExecutorList) {
            if (cartCommandExecutor.isApplicable(cartCommandType)) {
                cartCommandExecutor.execute(userId, restaurantId, itemId);
            }
        }
    }

    public List<MenuItem> getAllItemsOfCart(@NonNull final String userId, @NonNull final String restaurantId) {
        List<MenuItem> menuItems = new ArrayList<>();
        List<String> menuItemIds = cartData.getMenuItemIds(userId, restaurantId);
        menuItemIds.forEach(menuItem -> menuItems.add(foodMenuService.getMenuItemById(menuItem)));
        return menuItems;
    }
}
