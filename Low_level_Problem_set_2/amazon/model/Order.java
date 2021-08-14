package amazon.model;

import amazon.constants.OrderStatus;
import amazon.constants.ShippingStatus;

import java.util.UUID;

/**
 * @author priyamvora
 * @created 23/04/2021
 */
public class Order {
    private final String orderId;
    private final String productId;
    private final Integer qty;
    private final String address;
    private ShippingStatus shippingStatus;
    private PaymentInfo paymentInfo;
    private OrderStatus orderStatus;
    private final Long orderTs;

    public Order(String productId, Integer qty, String address) {
        this.orderId = UUID.randomUUID().toString();
        this.productId = productId;
        this.qty = qty;
        this.address = address;
        this.shippingStatus = ShippingStatus.ORDER_PLACED;
        this.orderStatus = OrderStatus.PLACED;
        this.orderTs = System.currentTimeMillis();
    }

    public void setShippingStatus(ShippingStatus shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getQty() {
        return qty;
    }

    public String getAddress() {
        return address;
    }

    public ShippingStatus getShippingStatus() {
        return shippingStatus;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", productId='" + productId + '\'' +
                ", qty=" + qty +
                ", address='" + address + '\'' +
                ", shippingStatus=" + shippingStatus +
                ", paymentInfo=" + paymentInfo +
                ", orderStatus=" + orderStatus +
                ", orderTs=" + orderTs +
                '}';
    }
}
