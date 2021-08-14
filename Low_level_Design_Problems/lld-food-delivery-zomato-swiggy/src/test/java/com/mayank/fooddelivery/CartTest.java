package com.mayank.fooddelivery;

import com.mayank.fooddelivery.commands.AddCartCommandExecutor;
import com.mayank.fooddelivery.commands.CartCommandExecutor;
import com.mayank.fooddelivery.commands.RemoveCartCommandExecutor;
import com.mayank.fooddelivery.controllers.CartController;
import com.mayank.fooddelivery.controllers.FoodMenuController;
import com.mayank.fooddelivery.datastore.CartData;
import com.mayank.fooddelivery.datastore.FoodMenuData;
import com.mayank.fooddelivery.model.CartCommandType;
import com.mayank.fooddelivery.model.MenuItem;
import com.mayank.fooddelivery.services.CartService;
import com.mayank.fooddelivery.services.FoodMenuService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CartTest {
    CartController cartController;
    FoodMenuController foodMenuController;

    @BeforeEach
    void setup() {
        CartData cartData = new CartData();
        FoodMenuService foodMenuService = new FoodMenuService(new FoodMenuData());
        List<CartCommandExecutor> commandExecutors = List.of(new AddCartCommandExecutor(foodMenuService, cartData),
                new RemoveCartCommandExecutor(cartData));
        CartService cartService = new CartService(cartData, commandExecutors, foodMenuService);
        cartController = new CartController(cartService);
        foodMenuController = new FoodMenuController(foodMenuService);
    }

    @Test
    void CartTest() {
        List<MenuItem> menuItemList = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            menuItemList.add(TestHelper.buildMenuItem("ITEM" + i, "Item Name " + i, i * 1000));
        }
        foodMenuController.addMenuByRestaurantId("MENU1", "REST1", menuItemList);
        foodMenuController.addMenuByRestaurantId("MENU2", "REST2", menuItemList);
        foodMenuController.addMenuByRestaurantId("MENU1", "REST3", menuItemList);

        cartController.updateCart("USER1","REST1","ITEM2", CartCommandType.ADD_ITEM);

        System.out.println(cartController.getAllItemsOfCart("USER1", "REST1"));

        cartController.updateCart("USER1","REST1","ITEM2", CartCommandType.REMOVE_ITEM);

        System.out.println(cartController.getAllItemsOfCart("USER1", "REST1"));

        cartController.updateCart("USER1","REST1","ITEM2", CartCommandType.ADD_ITEM);

        System.out.println(cartController.getAllItemsOfCart("USER1", "REST1"));

        cartController.clearCart("USER1", "REST1");

    }
}
