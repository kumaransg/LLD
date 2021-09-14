package service;

import constants.OrderType;
import dao.StockExchangeDao;
import model.BuyOrder;
import model.OrderFactory;
import model.SellOrder;
import ui.ExecuteOrders;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class StockExchangeServiceImpl implements StockExchangeService {

    StockExchangeDao stockExchangeDao = new StockExchangeDao();
    ExecuteOrders ui = new ExecuteOrders();

    @Override
    public void addSellOrder(String orderId, String stockName, Double price, int quantity, LocalTime time) {
        SellOrder order = (SellOrder) OrderFactory
            .getOrder(OrderType.SELL_ORDER, orderId, stockName, price, quantity, time);
        stockExchangeDao.addSellOrder(order);
    }

    @Override
    public void matchAndExecuteBuyOrder(String orderId, String stockName, Double price, int quantity, LocalTime time) {
        BuyOrder order = (BuyOrder) OrderFactory
            .getOrder(OrderType.BUY_ORDER, orderId, stockName, price, quantity, time);
        executeOrder(order);

    }

    private void executeOrder(BuyOrder buy) {
        PriorityQueue<SellOrder> queue = stockExchangeDao.getSellOrderPriorityQueue();
        List<SellOrder> sellOrdersList = new ArrayList<>();
        while (!queue.isEmpty()) {
            SellOrder sell = queue.peek();
            if (sell.getPrice() > buy.getPrice()) {
                break;
            } else {
                sellOrdersList.add(0, queue.poll());
            }
        }

        // now we have got the list in higher value less than the current buy
        int buyQuantity = buy.getQuantity();
        for (SellOrder sell : sellOrdersList) {
            if (sell.getQuantity() > buyQuantity) {
                int sellQuantity = sell.getQuantity() - buyQuantity;
                sell.setQuantity(sellQuantity);
                ui.executeOrders(buy.getOrderId(), sell.getPrice(), buyQuantity, sell.getOrderId());
                break;
            } else {
                if (sell.getQuantity() <= buyQuantity) {
                    buyQuantity -= sell.getQuantity();
                    ui.executeOrders(buy.getOrderId(), sell.getPrice(), sell.getQuantity(), sell.getOrderId());
                    sell.setQuantity(-1);
                }
            }
        }

        // add back the list to queue for future
        for (SellOrder sell : sellOrdersList) {
            if (sell.getQuantity() != -1) {
                stockExchangeDao.addSellOrder(sell);
            }
        }
    }
}
