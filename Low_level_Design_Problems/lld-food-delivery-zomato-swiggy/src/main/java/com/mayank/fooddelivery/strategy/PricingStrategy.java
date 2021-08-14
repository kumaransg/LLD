package com.mayank.fooddelivery.strategy;

import com.mayank.fooddelivery.model.Bill;
import com.mayank.fooddelivery.model.CouponCode;
import com.mayank.fooddelivery.model.MenuItem;

import java.util.List;


public interface PricingStrategy {
    Bill generateBill(List<MenuItem> menuItemList);

    boolean isApplicable(CouponCode couponCode);
}
