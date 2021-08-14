package com.example.swiggy.model;

import java.util.List;

public interface DeliveryExecutiveScoreCalculationStrategy {
    public double getScore(Order order, DeliveryExecutive deliveryExecutive);
}
