package com.example.swiggy.model;

public class Order {
    private int id;
    private SwiggyCustomer customer;
    private Restaurant restaurant;
    private long orderedTime;
    private OrderStates orderStates;

    public Order(int id, SwiggyCustomer customer, Restaurant restaurant, long orderedTime, OrderStates orderStates) {
        this.id = id;
        this.customer = customer;
        this.restaurant = restaurant;
        this.orderedTime = orderedTime;
        this.orderStates = orderStates;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SwiggyCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(SwiggyCustomer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public long getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(long orderedTime) {
        this.orderedTime = orderedTime;
    }

    public OrderStates getOrderStates() {
        return orderStates;
    }

    public void setOrderStates(OrderStates orderStates) {
        this.orderStates = orderStates;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", restaurant=" + restaurant +
                ", orderedTime=" + orderedTime +
                ", orderStates=" + orderStates +
                '}';
    }
}
