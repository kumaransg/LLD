package com.mayank.fooddelivery.services;

import com.mayank.fooddelivery.datastore.DeliveryData;
import com.mayank.fooddelivery.exceptions.ExceptionType;
import com.mayank.fooddelivery.exceptions.FoodDeliveryException;
import com.mayank.fooddelivery.model.Delivery;
import com.mayank.fooddelivery.model.Order;
import com.mayank.fooddelivery.model.OrderStatus;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DeliveryService {
    private DeliveryData deliveryData;
    private OrderService orderService;

    @Autowired
    public DeliveryService(DeliveryData deliveryData, OrderService orderService) {
        this.deliveryData = deliveryData;
        this.orderService = orderService;
    }

    public void addDelivery(@NonNull final Delivery delivery) {
        if (deliveryData.getDeliveryById().containsKey(delivery)) {
            throw new FoodDeliveryException(ExceptionType.DELIVERY_ALREADY_EXISTS, "delivery already exists");
        }
        Order order = orderService.getOrderById(delivery.getOrderId());
        if (order.getOrderStatus() != OrderStatus.PLACED) {
            throw new FoodDeliveryException(ExceptionType.ORDER_NOT_CONFIRMED, "Order not confirmed");
        }
        deliveryData.getDeliveryById().put(delivery.getId(), delivery);
        List<String> deliveryIds = deliveryData.getDeliveryIdsByDeliveryBoyId()
                .getOrDefault(delivery.getId(), new ArrayList<>());
        deliveryIds.add(delivery.getId());
        deliveryData.getDeliveryIdsByDeliveryBoyId().put(delivery.getDeliveryBoyId(), deliveryIds);
    }

    public Delivery getDeliveryById(@NonNull final String deliveryId) {
        if (!deliveryData.getDeliveryById().containsKey(deliveryId)) {
            throw new FoodDeliveryException(ExceptionType.DELIVERY_NOT_FOUND, "delivery not found");
        }
        return deliveryData.getDeliveryById().get(deliveryId);
    }

    public List<Delivery> getDeliveriesByDeliveryBoyId(@NonNull final String deliveryBoyId) {
        List<Delivery> deliveryList = new ArrayList<>();
        List<String> deliveryIds = deliveryData.getDeliveryIdsByDeliveryBoyId().get(deliveryBoyId);
        deliveryIds.forEach(id -> deliveryList.add(getDeliveryById(id)));
        return deliveryList;
    }

    public OrderStatus getOrderStatus(@NonNull final String deliveryId) {
        Delivery delivery = getDeliveryById(deliveryId);
        Order order = orderService.getOrderById(delivery.getOrderId());
        updateOrderStatus(delivery, order);
        return order.getOrderStatus();
    }

    private void updateOrderStatus(@NonNull final Delivery delivery, @NonNull final Order order) {
        long diffInTime = new Date().getTime() - delivery.getDeliveryTime().getTime();
        long diffInMinutes = diffInTime / (60 * 1000) % 60;
        if (diffInMinutes > 30) {
            order.markOrderDelivered();
        } else if (diffInMinutes > 20) {
            order.markOrderOutForDelivery();
        }
    }
}
