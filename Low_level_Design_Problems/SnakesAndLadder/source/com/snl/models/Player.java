package com.snl.models;

public class Player {
    private String name;
    private int curPosition;

    public Player(String name) {
        this.name = name;
        this.curPosition = 0;
    }

    public String getName() {
        return name;
    }

    public int getCurPosition() {
        return curPosition;
    }

    public void setCurPosition(int curPosition) {
        this.curPosition = curPosition;
    }
}
