package com.mayank.fooddelivery.model;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
public class Payment {
    private String id;
    private String orderId;
    private Map<PaymentType, Double> amountPaid;
    private CouponCode couponCode;
    private PaymentStatus paymentStatus;

    public Payment(String id, String orderId, Map<PaymentType, Double> amountPaid, CouponCode couponCode) {
        this.id = id;
        this.orderId = orderId;
        this.amountPaid = amountPaid;
        this.couponCode = couponCode;
        paymentStatus = PaymentStatus.PENDING;
    }

    public void markPaymentDeclined() {
        paymentStatus = PaymentStatus.DECLINED;
    }

    public void markPaymentApproved() {
        paymentStatus = PaymentStatus.APPROVED;
    }

    public void markPaymentTimeout() {
        paymentStatus = PaymentStatus.TIMEOUT;
    }
}
