package com.mayank.fooddelivery.services;

import com.mayank.fooddelivery.commands.OrderCommandExecutor;
import com.mayank.fooddelivery.datastore.OrderData;
import com.mayank.fooddelivery.exceptions.ExceptionType;
import com.mayank.fooddelivery.exceptions.FoodDeliveryException;
import com.mayank.fooddelivery.model.Order;
import com.mayank.fooddelivery.model.OrderCommandType;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private OrderData orderData;
    private List<OrderCommandExecutor> orderCommandExecutorList;

    @Autowired
    public OrderService(OrderData orderData, List<OrderCommandExecutor> orderCommandExecutorList) {
        this.orderData = orderData;
        this.orderCommandExecutorList = orderCommandExecutorList;
    }

    public void updateOrder(@NonNull final Order order, @NonNull final OrderCommandType orderCommandType) {
        for (OrderCommandExecutor orderCommandExecutor : orderCommandExecutorList) {
            if (orderCommandExecutor.isApplicable(orderCommandType)) {
                orderCommandExecutor.execute(order);
            }
        }
    }

    public Order getOrderById(@NonNull final String orderId) {
        if (!orderData.getOrderById().containsKey(orderId)) {
            throw new FoodDeliveryException(ExceptionType.ORDER_NOT_FOUND, "order not found");
        }
        return orderData.getOrderById().get(orderId);
    }

    public List<Order> getAllOrdersByRestaurantId(@NonNull final String userId, @NonNull final String restaurantId) {
        List<Order> orderList = getAllOrders(userId);
        return orderList.stream().filter(order -> order.getRestaurantId()
                .equals(restaurantId)).collect(Collectors.toList());
    }

    public List<Order> getAllOrders(@NonNull final String userId) {
        List<Order> orderList = new ArrayList<>();
        List<String> orderIds = orderData.getOrderIdsByUserId().get(userId);
        if (Optional.of(orderIds).isPresent()) {
            orderIds.forEach(orderId -> orderList.add(getOrderById(orderId)));
        }
        return orderList;
    }

}
