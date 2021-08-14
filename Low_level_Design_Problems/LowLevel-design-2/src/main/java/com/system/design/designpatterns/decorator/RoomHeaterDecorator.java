package com.system.design.designpatterns.decorator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class RoomHeaterDecorator implements Room {
    Room room;
    private double cost;
    @Override
    public double getCost() {
        return this.cost + room.getCost();
    }
}
