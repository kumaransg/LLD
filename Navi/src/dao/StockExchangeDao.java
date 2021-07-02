package dao;

import model.BuyOrder;
import model.SellOrder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
This Dao maintains the Sell order in the queue based on the comparator
 */
public class StockExchangeDao {

    private PriorityQueue<SellOrder> sellOrderPriorityQueue = new PriorityQueue<>(new Comparator<SellOrder>() {
        @Override
        public int compare(SellOrder o1, SellOrder o2) {
            // if same price return the more quantity
            if (o1.getPrice() == o2.getPrice()) {
                return o2.getQuantity() - o1.getQuantity();
            }
            return Double.compare(o1.getPrice(), o2.getPrice());
        }
    });

    private ArrayList<BuyOrder> executedBuyOrder = new ArrayList<>();

    public PriorityQueue<SellOrder> getSellOrderPriorityQueue() {
        return sellOrderPriorityQueue;
    }

    public void addSellOrder(SellOrder order) {
        sellOrderPriorityQueue.add(order);
    }

    private void addCompletedOrder(BuyOrder order) {
        executedBuyOrder.add(order);
    }

}
