package com.system.design.lld.snakegame.model;

public enum CellType {
    FOOD("1"),
    EMPTY("0"),
    SNAKE_NODE("X");
    private String symbol;
    CellType(String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return this.symbol;
    }
}
