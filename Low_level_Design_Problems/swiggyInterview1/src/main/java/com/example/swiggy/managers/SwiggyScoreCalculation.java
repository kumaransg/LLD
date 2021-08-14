package com.example.swiggy.managers;

import com.example.swiggy.helpers.DistanceHelper;
import com.example.swiggy.model.DeliveryExecutive;
import com.example.swiggy.model.DeliveryExecutiveScoreCalculationStrategy;
import com.example.swiggy.model.Order;

public class SwiggyScoreCalculation implements DeliveryExecutiveScoreCalculationStrategy {
    public final double IDEA_DISTANCE = 1;
    public final double IDEA_ORDER_WAITING_TIME = 1000 ; //Approximate 16 minute in epoch
    public final double IDEAL_DE_TIME = 1000 ; //Approximate 16 minute in epoch
    public final double WEIGHT_TO_DISTANCE = 0.6 ; //Approximate 16 minute in epoch
    public final double WEIGHT_TO_ORDER_WT = 0.3 ; //Approximate 16 minute in epoch
    public final double WEIGHT_TO_DE_WT = 0.1 ; //Approximate 16 minute in epoch

    @Override
    public double getScore(Order order, DeliveryExecutive deliveryExecutive) {
        double score = 0;
        double distance = DistanceHelper.getHaversineDistance(order.getRestaurant().getLocation(), deliveryExecutive.getLocation());
        double orderWaitingTime = getElapsedOrderTime(order.getOrderedTime());
        double de_wait_time = getElapsedLastOrderDeliveredTime(deliveryExecutive.getLastOrderDeliveredTime());
        score += ((IDEA_DISTANCE-distance) / IDEA_DISTANCE) * WEIGHT_TO_DISTANCE;
        score += ((orderWaitingTime-IDEA_ORDER_WAITING_TIME) / IDEA_ORDER_WAITING_TIME) * WEIGHT_TO_ORDER_WT;
        score += ((de_wait_time-IDEAL_DE_TIME) / IDEAL_DE_TIME) * WEIGHT_TO_DE_WT;
        return score;
    }

    private double getElapsedOrderTime(long orderedTime) {
        long currentTime = System.currentTimeMillis();
        return Math.abs(currentTime - orderedTime);
    }

    private double getElapsedLastOrderDeliveredTime(long lastOrderDeliveredTime) {
        long currentTime = System.currentTimeMillis();
        return Math.abs(currentTime - lastOrderDeliveredTime);
    }
}
