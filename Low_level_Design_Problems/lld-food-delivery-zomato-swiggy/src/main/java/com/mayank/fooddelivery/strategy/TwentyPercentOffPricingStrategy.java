package com.mayank.fooddelivery.strategy;

import com.mayank.fooddelivery.model.Bill;
import com.mayank.fooddelivery.model.CouponCode;
import com.mayank.fooddelivery.model.MenuItem;

import java.util.List;
import java.util.UUID;

public class TwentyPercentOffPricingStrategy implements PricingStrategy {
    private final double discountPercent = 20;

    @Override
    public Bill generateBill(List<MenuItem> menuItemList) {
        double totalCost = menuItemList.stream().mapToDouble(menuItem -> menuItem.getPrice()).sum();
        return Bill.builder()
                .id(UUID.randomUUID().toString())
                .totalCost(totalCost)
                .discount(totalCost * discountPercent / 100)
                .amountToBePaid(totalCost - totalCost * discountPercent / 100)
                .tax((totalCost - totalCost * discountPercent / 100) * 0.05)
                .build();
    }

    @Override
    public boolean isApplicable(CouponCode couponCode) {
        return couponCode == CouponCode.TWENTY_PERCENT_OFF;
    }
}
