package model;

import constants.OrderType;

import java.time.LocalTime;

public class OrderFactory {
    public static Order getOrder(OrderType orderType, String orderId, String stockName, Double price, int quantity,
        LocalTime time) {
        if (orderType == OrderType.SELL_ORDER) {
            return new SellOrder(orderId, stockName, price, quantity, time);

        } else if (orderType == OrderType.BUY_ORDER) {
            return new BuyOrder(orderId, stockName, price, quantity, time);

        }
        return null;
    }
}
