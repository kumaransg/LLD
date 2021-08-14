package StockBroking.model;

import java.util.UUID;

/**
 * @author priyamvora
 * @created 26/04/2021
 */
public class Stock {
    private final String stockId;
    private final String name;
    private final String shortCode;
    private Double cmp;

    public Stock(String name, String shortCode, Double cmp) {
        this.stockId = UUID.randomUUID().toString();
        this.name = name;
        this.shortCode = shortCode;
        this.cmp = cmp;
    }

    public String getStockId() {
        return stockId;
    }

    public String getName() {
        return name;
    }

    public String getShortCode() {
        return shortCode;
    }

    public Double getCmp() {
        return cmp;
    }

    public void setCmp(Double cmp) {
        this.cmp = cmp;
    }
}
