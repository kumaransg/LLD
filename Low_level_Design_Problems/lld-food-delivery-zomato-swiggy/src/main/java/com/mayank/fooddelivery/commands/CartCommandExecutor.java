package com.mayank.fooddelivery.commands;

import com.mayank.fooddelivery.exceptions.ExceptionType;
import com.mayank.fooddelivery.exceptions.FoodDeliveryException;
import com.mayank.fooddelivery.model.CartCommandType;
import lombok.NonNull;

public abstract class CartCommandExecutor {
    public void execute(@NonNull final String userId, @NonNull final String restaurantId,
                        @NonNull final String itemId) {
        if (!isValid(userId, restaurantId, itemId)) {
            throw new FoodDeliveryException(ExceptionType.MENU_ITEM_NOT_FOUND, "menu item not found");
        }
        executeCommand(userId, restaurantId, itemId);
    }

    public abstract boolean isValid(final String userId, final String restaurantId, final String itemId);

    public abstract void executeCommand(final String userId, final String restaurantId, final String itemId);

    public abstract boolean isApplicable(final CartCommandType cartCommandType);

}
