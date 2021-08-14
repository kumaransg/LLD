package com.mayank.fooddelivery.commands;

import com.mayank.fooddelivery.datastore.OrderData;
import com.mayank.fooddelivery.model.Order;
import com.mayank.fooddelivery.model.OrderCommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CancelOrderCommandExecutor extends OrderCommandExecutor {
    private OrderData orderData;

    @Autowired
    public CancelOrderCommandExecutor(OrderData orderData) {
        this.orderData = orderData;
    }

    @Override
    public boolean isValid(Order order) {
        if (!orderData.getOrderById().containsKey(order.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public void executeCommand(Order order) {
        order.markOrderCancelled();
    }

    @Override
    public boolean isApplicable(OrderCommandType orderCommandType) {
        return orderCommandType == OrderCommandType.CANCEL;
    }
}
