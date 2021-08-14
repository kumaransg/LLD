package com.mayank.fooddelivery.commands;

import com.mayank.fooddelivery.exceptions.ExceptionType;
import com.mayank.fooddelivery.exceptions.FoodDeliveryException;
import com.mayank.fooddelivery.model.Order;
import com.mayank.fooddelivery.model.OrderCommandType;
import lombok.NonNull;

public abstract class OrderCommandExecutor {
    public void execute(@NonNull final Order order) {
        if (!isValid(order)) {
            throw new FoodDeliveryException(ExceptionType.ORDER_NOT_VALID, "order not valid");
        }
        executeCommand(order);
    }

    public abstract boolean isValid(final Order order);

    public abstract void executeCommand(final Order order);

    public abstract boolean isApplicable(final OrderCommandType orderCommandType);
}
