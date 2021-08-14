package payments;

import order.Order;

public interface IPaymentStrategy {
    void pay(Order order);
}
