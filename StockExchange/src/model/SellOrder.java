package model;

import java.time.LocalTime;

public class SellOrder extends Order {
    public SellOrder(String orderId, String stockName, Double price, int quantity, LocalTime time) {
        super(orderId, stockName, price, quantity, time);
    }

    @Override
    public String getOrderId() {
        return super.getOrderId();
    }

    @Override
    public void setOrderId(String orderId) {
        super.setOrderId(orderId);
    }

    @Override
    public String getStockName() {
        return super.getStockName();
    }

    @Override
    public void setStockName(String stockName) {
        super.setStockName(stockName);
    }

    @Override
    public Double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(Double price) {
        super.setPrice(price);
    }

    @Override
    public int getQuantity() {
        return super.getQuantity();
    }

    @Override
    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
    }

    @Override
    public LocalTime getTime() {
        return super.getTime();
    }

    @Override
    public void setTime(LocalTime time) {
        super.setTime(time);
    }
}
