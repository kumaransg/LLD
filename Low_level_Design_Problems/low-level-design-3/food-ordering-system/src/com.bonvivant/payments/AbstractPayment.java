package payments;

import order.Order;

// TBD
public class AbstractPayment {
    IPaymentStrategy paymentStrategy;
    Order order;

    public void doPayment(Order order) {
        paymentStrategy.pay(order);
    }
}
