package com.example.swiggy.model;

import java.util.List;

public interface AssignDeliveryExecutiveStrategy {
    boolean assignExecutiveforOrder(Order order, List<DeliveryExecutive> deliveryExecutives);
}
