package com.mayank.fooddelivery.services;

import com.mayank.fooddelivery.datastore.PaymentData;
import com.mayank.fooddelivery.exceptions.ExceptionType;
import com.mayank.fooddelivery.exceptions.FoodDeliveryException;
import com.mayank.fooddelivery.model.Bill;
import com.mayank.fooddelivery.model.Order;
import com.mayank.fooddelivery.model.Payment;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {
    private PaymentData paymentData;
    private PricingService pricingService;
    private OrderService orderService;

    @Autowired
    public PaymentService(PaymentData paymentData, PricingService pricingService, OrderService orderService) {
        this.paymentData = paymentData;
        this.pricingService = pricingService;
        this.orderService = orderService;
    }

    public void addPayment(@NonNull final Payment payment) {
        Order order = orderService.getOrderById(payment.getOrderId());
        if (!validatePayment(payment, order)) {
            order.markOrderCancelled();
            payment.markPaymentDeclined();
            return;
        }
        paymentData.getPaymentById().put(payment.getId(), payment);
        paymentData.getPaymentIdByOrderId().put(payment.getOrderId(), payment.getId());
        order.markOrderPlaced();
        payment.markPaymentApproved();
    }

    public Payment getPaymentById(@NonNull final String paymentId) {
        if (!paymentData.getPaymentById().containsKey(paymentId)) {
            throw new FoodDeliveryException(ExceptionType.PAYMENT_NOT_EXISTS, "payment not exists");
        }
        return paymentData.getPaymentById().get(paymentId);
    }

    public Payment getPaymentByOrderId(@NonNull final String orderId) {
        String paymentId = paymentData.getPaymentIdByOrderId().get(orderId);
        return getPaymentById(paymentId);
    }

    private boolean validatePayment(Payment payment, Order order) {
        Bill bill = pricingService.getBill(order.getUserId(), order.getRestaurantId(), payment.getCouponCode());
        double amountPaid = payment.getAmountPaid().values().stream().mapToDouble(amount -> amount).sum();
        return BigDecimal.valueOf(amountPaid).compareTo(BigDecimal.valueOf(bill.getAmountToBePaid())) == 0;
    }
}
