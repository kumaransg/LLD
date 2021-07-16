package com.system.design.designpatterns.decorator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class StandardRoom implements Room {
    private double cost;
    @Override
    public double getCost() {
        return this.cost;
    }
}
