package com.mayank.fooddelivery;

import com.mayank.fooddelivery.commands.AddCartCommandExecutor;
import com.mayank.fooddelivery.commands.CartCommandExecutor;
import com.mayank.fooddelivery.commands.RemoveCartCommandExecutor;
import com.mayank.fooddelivery.controllers.CartController;
import com.mayank.fooddelivery.controllers.FoodMenuController;
import com.mayank.fooddelivery.controllers.PricingController;
import com.mayank.fooddelivery.datastore.CartData;
import com.mayank.fooddelivery.datastore.FoodMenuData;
import com.mayank.fooddelivery.model.CartCommandType;
import com.mayank.fooddelivery.model.CouponCode;
import com.mayank.fooddelivery.model.MenuItem;
import com.mayank.fooddelivery.services.CartService;
import com.mayank.fooddelivery.services.FoodMenuService;
import com.mayank.fooddelivery.services.PricingService;
import com.mayank.fooddelivery.strategy.FiveHundredOffPricingStrategy;
import com.mayank.fooddelivery.strategy.PricingStrategy;
import com.mayank.fooddelivery.strategy.TwentyPercentOffPricingStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PricingTest {
    PricingController pricingController;
    FoodMenuController foodMenuController;
    CartController cartController;

    @BeforeEach
    void setup() {
        List<PricingStrategy> pricingStrategyList = List.of(new TwentyPercentOffPricingStrategy(),
                new FiveHundredOffPricingStrategy());
        CartData cartData = new CartData();
        FoodMenuService foodMenuService = new FoodMenuService(new FoodMenuData());
        List<CartCommandExecutor> commandExecutors = List.of(new AddCartCommandExecutor(foodMenuService, cartData),
                new RemoveCartCommandExecutor(cartData));
        CartService cartService = new CartService(cartData, commandExecutors, foodMenuService);
        PricingService pricingService = new PricingService(pricingStrategyList, cartService);
        pricingController = new PricingController(pricingService);
        cartController = new CartController(cartService);
        foodMenuController = new FoodMenuController(foodMenuService);
    }

    @Test
    void PricingTest(){
        List<MenuItem> menuItemList = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            menuItemList.add(TestHelper.buildMenuItem("ITEM" + i, "Item Name " + i, i * 1000));
        }
        foodMenuController.addMenuByRestaurantId("MENU1", "REST1", menuItemList);
        foodMenuController.addMenuByRestaurantId("MENU2", "REST2", menuItemList);
        foodMenuController.addMenuByRestaurantId("MENU1", "REST3", menuItemList);

        cartController.updateCart("USER1","REST1","ITEM2", CartCommandType.ADD_ITEM);

        System.out.println(pricingController
                .getBill("USER1", "REST1", CouponCode.TWENTY_PERCENT_OFF));
    }
}
