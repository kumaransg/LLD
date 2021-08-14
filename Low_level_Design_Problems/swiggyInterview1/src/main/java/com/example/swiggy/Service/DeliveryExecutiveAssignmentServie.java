package com.example.swiggy.Service;

import com.example.swiggy.model.*;

import java.util.List;

public class DeliveryExecutiveAssignmentServie {
    private AssignDeliveryExecutiveStrategy assignDeliveryExecutiveStrategy;

    public DeliveryExecutiveAssignmentServie(AssignDeliveryExecutiveStrategy assignDeliveryExecutiveStrategy) {
        this.assignDeliveryExecutiveStrategy = assignDeliveryExecutiveStrategy;
    }

    public void assignDeliveryExecutives(List<Order> orderList, List<DeliveryExecutive> deliveryExecutiveList) {
        for(Order order: orderList) {
            if(OrderStates.ORDERED.equals(order.getOrderStates())) {
                if(!assignDeliveryExecutiveStrategy.assignExecutiveforOrder(order, deliveryExecutiveList)) {
                    System.out.println("Order not processed");
                }
            }
        }

    }
}
