package com.example.swiggy.managers;

import com.example.swiggy.helpers.DistanceHelper;
import com.example.swiggy.model.*;

import java.util.List;

public class SwiggyDeliveryStrategy extends DeliveryStrategy implements AssignDeliveryExecutiveStrategy {
    private final int INF = 99999;
    private final int THRESHOLD_HAPPY_SCORE = -111;

    public SwiggyDeliveryStrategy(DeliveryExecutiveScoreCalculationStrategy deliveryExecutiveScoreCalculationStrategy) {
        this.deliveryExecutiveScoreCalculationStrategy = deliveryExecutiveScoreCalculationStrategy;
    }

    @Override
    public boolean assignExecutiveforOrder(Order order, List<DeliveryExecutive> deliveryExecutives) {
        DeliveryExecutive assignedDeliveryExecutive = null;
        double highestscore = -INF;
        for(DeliveryExecutive deliveryExecutive: deliveryExecutives) {
            if(deliveryExecutive.isAvailable()) {
                double score = deliveryExecutiveScoreCalculationStrategy.getScore(order, deliveryExecutive);
                System.out.println("Order Id " + order.getId() + " Score "+ score + " Delivery Id " + deliveryExecutive.getId());
                if (score > highestscore) {
                    score = highestscore;
                    assignedDeliveryExecutive = deliveryExecutive;
                }
            }
        }
        // Idea is that we should not assign another city or very far guy as he is only available at that point of time.
        if(assignedDeliveryExecutive != null) {
            System.out.println("Order processed with " + order.getId() + " with delivery executive id " + assignedDeliveryExecutive.getId());
            assignedDeliveryExecutive.setAvailable(false);
            order.setOrderStates(OrderStates.DE_ASSIGNED);
            return true;
        }
        return false;
    }


}

