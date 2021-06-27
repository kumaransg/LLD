package amazon;

import java.util.Date;
import java.util.List;

public class Order {
    int id;
    List<Item> items;
    double orderValue;
    Buyer buyer;
    Date orderDate;
    NotificationService notficationSvc;
    
    List<OrderLog> orderLog;
    
    public OrderStatus placeOrder() {return null;}
    public OrderStatus trackOrder() {return null;}
    public void addOrderLogs() {}
    public PaymentStatus makePayment(PaymentType payment) {return null;}
}
