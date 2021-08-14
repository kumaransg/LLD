package com.mayank.fooddelivery;

import com.mayank.fooddelivery.commands.*;
import com.mayank.fooddelivery.controllers.*;
import com.mayank.fooddelivery.datastore.*;
import com.mayank.fooddelivery.model.*;
import com.mayank.fooddelivery.services.*;
import com.mayank.fooddelivery.strategy.FiveHundredOffPricingStrategy;
import com.mayank.fooddelivery.strategy.PricingStrategy;
import com.mayank.fooddelivery.strategy.TwentyPercentOffPricingStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class DeliveryTest {
    DeliveryController deliveryController;
    OrderController orderController;
    FoodMenuController foodMenuController;
    PaymentController paymentController;
    CartController cartController;

    @BeforeEach
    void setup() {
        OrderData orderData = new OrderData();
        List<OrderCommandExecutor> orderCommandExecutorList = List.of(new PlaceOrderCommandExecutor(orderData),
                new CancelOrderCommandExecutor(orderData));
        OrderService orderService = new OrderService(orderData, orderCommandExecutorList);

        List<PricingStrategy> pricingStrategyList = List.of(new TwentyPercentOffPricingStrategy(),
                new FiveHundredOffPricingStrategy());
        CartData cartData = new CartData();
        FoodMenuService foodMenuService = new FoodMenuService(new FoodMenuData());
        List<CartCommandExecutor> commandExecutors = List.of(new AddCartCommandExecutor(foodMenuService, cartData),
                new RemoveCartCommandExecutor(cartData));
        CartService cartService = new CartService(cartData, commandExecutors, foodMenuService);
        PricingService pricingService = new PricingService(pricingStrategyList, cartService);
        PaymentService paymentService = new PaymentService(new PaymentData(), pricingService, orderService);

        DeliveryService deliveryService = new DeliveryService(new DeliveryData(), orderService);
        deliveryController = new DeliveryController(deliveryService);
        paymentController = new PaymentController(paymentService);
        orderController = new OrderController(orderService);
        foodMenuController = new FoodMenuController(foodMenuService);
        cartController = new CartController(cartService);
    }

    @Test
    void DeliveryFlowTest() {
        List<MenuItem> menuItemList = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            menuItemList.add(TestHelper.buildMenuItem("ITEM" + i, "Item Name " + i, i * 1000));
        }

        foodMenuController.addMenuByRestaurantId("MENU1", "REST1", menuItemList);
        foodMenuController.addMenuByRestaurantId("MENU2", "REST2", menuItemList);
        foodMenuController.addMenuByRestaurantId("MENU1", "REST3", menuItemList);

        cartController.updateCart("USER1", "REST1", "ITEM2", CartCommandType.ADD_ITEM);

        Order order = new Order("ORDER1", "USER1", "REST1", menuItemList);
        orderController.updateOrder(order, OrderCommandType.PLACE);

        Map<PaymentType, Double> amountPaidMap = new HashMap<>();
        amountPaidMap.put(PaymentType.DEBIT_CARD, 1200.0);
        amountPaidMap.put(PaymentType.WALLET, 400.0);
        paymentController.addPayment(
                new Payment("PAYMENT1", "ORDER1", amountPaidMap, CouponCode.TWENTY_PERCENT_OFF));

        Delivery delivery = Delivery.builder().id("ID1")
                .deliveryBoyId("DBID1")
                .orderId("ORDER1")
                .userId("USER1")
                .deliveryTime(new Date())
                .build();
        deliveryController.addDelivery(delivery);

        System.out.println(orderController.getOrderById("ORDER1"));

        System.out.println(paymentController.getPaymentById("PAYMENT1"));

        System.out.println(deliveryController.getDeliveryById("ID1"));

        System.out.println(deliveryController.getDeliveriesByDeliveryBoyId("DBID1"));

        System.out.println(deliveryController.getOrderStatus("ID1"));

        Delivery delivery2 = Delivery.builder().id("ID2")
                .deliveryBoyId("DBID2")
                .orderId("ORDER1")
                .userId("USER1")
                .deliveryTime(new Date(new Date().getTime() - 60000 * 24))
                .build();
        deliveryController.addDelivery(delivery2);
        System.out.println(deliveryController.getOrderStatus("ID2"));

    }
}
