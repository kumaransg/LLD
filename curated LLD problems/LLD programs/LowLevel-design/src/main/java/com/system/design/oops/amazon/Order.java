package com.system.design.oops.amazon;

import java.util.Date;
import java.util.List;

public class Order {
    private String orderNumber;
    private OrderStatus status;
    private Date orderDate;
    private List<OrderLog> orderLog;

    public boolean sendForShipment(){ return true;}
    public boolean makePayment(Payment payment){ return true;}
    public boolean addOrderLog(OrderLog orderLog){ return true;}
}
