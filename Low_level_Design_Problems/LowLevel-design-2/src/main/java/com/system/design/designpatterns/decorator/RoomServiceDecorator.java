package com.system.design.designpatterns.decorator;

public class RoomServiceDecorator implements Room {
    Room room;
    private double cost;
    @Override
    public double getCost() {
        return this.cost + room.getCost();
    }
}
