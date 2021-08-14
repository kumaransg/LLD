package core;

import models.DeliveryExecutive;
import models.Order;

public class OrderEntityAndDEDistanceCalculator implements IDistanceCalculator<Order, DeliveryExecutive>{

    private Double getMapDistance(Order order, DeliveryExecutive deliveryExecutive) {
        return order.getRestaurantLocation().getDistance(deliveryExecutive.getCurrent_location());
//        return 0D;
    }
    @Override
    public Double getDistance(Order order, DeliveryExecutive deliveryExecutive) {
        return order.getPriority() + deliveryExecutive.getPriority() - getMapDistance(order, deliveryExecutive) ; // code that calculates distance between an order and a DE
        // in case of extensions, we could do things here
    }
}
