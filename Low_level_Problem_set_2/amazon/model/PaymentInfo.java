package amazon.model;

import amazon.constants.PaymentMethods;

import java.util.UUID;

/**
 * @author priyamvora
 * @created 23/04/2021
 */
public class PaymentInfo {
    private final String transactionId;
    private final PaymentMethods paymentMethod;
    private final Double amount;

    public PaymentInfo(PaymentMethods paymentMethod, Double amount) {
        this.transactionId = UUID.randomUUID().toString();
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentInfo{" +
                "transactionId='" + transactionId + '\'' +
                ", paymentMethod=" + paymentMethod +
                ", amount=" + amount +
                '}';
    }
}
