package com.system.design.lld.snakeandladder.model;

public enum CellType {
    LADDER("1"),
    EMPTY("0"),
    SNAKE("X");
    private String symbol;
    CellType(String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return this.symbol;
    }
}
