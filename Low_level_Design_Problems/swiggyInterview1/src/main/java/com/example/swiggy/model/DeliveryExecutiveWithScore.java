package com.example.swiggy.model;

public class DeliveryExecutiveWithScore {
    private DeliveryExecutive deliveryExecutive;
    private Double score;

    public DeliveryExecutiveWithScore(DeliveryExecutive deliveryExecutive, Double score) {
        this.deliveryExecutive = deliveryExecutive;
        this.score = score;
    }

    public DeliveryExecutive getDeliveryExecutive() {
        return deliveryExecutive;
    }

    public void setDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
        this.deliveryExecutive = deliveryExecutive;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
