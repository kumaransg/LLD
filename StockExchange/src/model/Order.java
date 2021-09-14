package model;

import java.time.LocalTime;

abstract public class Order {
    String orderId;
    String stockName;
    Double price;
    int quantity;
    LocalTime time;

    public Order(String orderId, String stockName, Double price, int quantity, LocalTime time) {
        this.orderId = orderId;
        this.stockName = stockName;
        this.price = price;
        this.quantity = quantity;
        this.time = time;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
