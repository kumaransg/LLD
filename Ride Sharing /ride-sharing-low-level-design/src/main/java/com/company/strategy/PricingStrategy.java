package com.company.strategy;

public interface PricingStrategy {

  Integer AMT_PER_KM = 20;

  double calculateFare(int origin, int destination, int seats);

  double calculateFareForPreferred(int origin, int destination, int seats);
}
