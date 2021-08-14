package order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import enums.OrderStatus;
import java.util.stream.Collectors;
import restaurant.FoodItem;
import restaurant.Restaurant;

public class Order {
    UUID id;
    //item and quantity
    HashMap<FoodItem, Integer> items;
    Double amount;
    OrderStatus status;
    UUID placedAt;

    public Order(HashMap<FoodItem, Integer> orderItems, UUID restaurantUuid){
        this.id = UUID.randomUUID();
        this.items = orderItems;
        this.amount = calculateOrderAmount(orderItems);
        this.status = OrderStatus.PENDING;
        this.placedAt = restaurantUuid;
    }

    private Double calculateOrderAmount(HashMap<FoodItem, Integer> orderItems){
        Double orderAmount = 0.0;
        for(FoodItem foodItem: orderItems.keySet()){
            // quantity * item price
            orderAmount += (orderItems.get(foodItem) * foodItem.getPrice());
        }
        return orderAmount;
    }

    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @return the orderItems
     */
    public ArrayList<FoodItem> getOrderItems() {
        return items.keySet().stream().collect(Collectors.toCollection(ArrayList::new));
    }

    public HashMap<FoodItem, Integer> getItems() {
        return items;
    }

    /**
     * @return the placedAt
     */
    public UUID getPlacedAt() {
        return placedAt;
    }

    /**
     * @param placedAt the placedAt to set
     */
    public void setPlacedAt(UUID placedAt) {
        this.placedAt = placedAt;
    }

    /**
     * @return the status
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
