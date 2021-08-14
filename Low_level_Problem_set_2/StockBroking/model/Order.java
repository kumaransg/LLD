package StockBroking.model;

import java.util.UUID;

/**
 * @author priyamvora
 * @created 26/04/2021
 */
public class Order {
    private String orderId;
    private String stockId;
    private Integer qty;
    private Double buyPrice;
    private Double sellPrice;

    public Order(String stockId, Integer qty, Double buyPrice, Double sellPrice) {
        this.orderId = UUID.randomUUID().toString();
        this.stockId = stockId;
        this.qty = qty;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }
}
