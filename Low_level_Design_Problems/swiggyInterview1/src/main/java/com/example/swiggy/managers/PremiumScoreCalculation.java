package com.example.swiggy.managers;

import com.example.swiggy.model.DeliveryExecutive;
import com.example.swiggy.model.DeliveryExecutiveScoreCalculationStrategy;
import com.example.swiggy.model.Order;

public class PremiumScoreCalculation implements DeliveryExecutiveScoreCalculationStrategy {
    DeliveryExecutiveScoreCalculationStrategy deliveryExecutiveScoreCalculationStrategy;

    @Override
    public double getScore(Order order, DeliveryExecutive deliveryExecutive) {
        return 1.2 * deliveryExecutiveScoreCalculationStrategy.getScore(order, deliveryExecutive);
    }
}
