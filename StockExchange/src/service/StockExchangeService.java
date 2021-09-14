package service;

import java.time.LocalTime;

/*
The service which will be implemented by the clients
 */
public interface StockExchangeService {

    void addSellOrder(String orderId, String stockName, Double price, int quantity, LocalTime time);

    void matchAndExecuteBuyOrder(String orderId, String stockName, Double price, int quantity, LocalTime time);
}
