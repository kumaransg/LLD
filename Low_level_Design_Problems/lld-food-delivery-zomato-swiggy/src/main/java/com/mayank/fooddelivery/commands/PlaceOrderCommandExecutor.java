package com.mayank.fooddelivery.commands;

import com.mayank.fooddelivery.datastore.OrderData;
import com.mayank.fooddelivery.model.Order;
import com.mayank.fooddelivery.model.OrderCommandType;
import com.mayank.fooddelivery.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlaceOrderCommandExecutor extends OrderCommandExecutor {
    private OrderData orderData;

    @Autowired
    public PlaceOrderCommandExecutor(OrderData orderData) {
        this.orderData = orderData;
    }

    @Override
    public boolean isValid(Order order) {
        if (!(order.getOrderStatus() == OrderStatus.PENDING)) {
            return false;
        }
        return true;
    }

    @Override
    public void executeCommand(Order order) {
        orderData.getOrderById().put(order.getId(), order);
        List<String> orderIds = orderData.getOrderIdsByUserId().getOrDefault(order.getUserId(), new ArrayList<>());
        orderIds.add(order.getId());
        orderData.getOrderIdsByUserId().put(order.getUserId(), orderIds);
        order.markOrderWaitingForPayment();
    }

    @Override
    public boolean isApplicable(OrderCommandType orderCommandType) {
        return orderCommandType == OrderCommandType.PLACE;
    }
}
