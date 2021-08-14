package com.snl.models;

public class NumberBox {
    private int number;
    private boolean hasLadderStart;
    private int ladderEnd;
    private boolean hasSnakeHead;
    private int snakeTail;

    public NumberBox(int number) {
        this.number = number;
        this.hasLadderStart = false;
        this.ladderEnd = -1;
        this.hasSnakeHead = false;
        this.snakeTail = -1;
    }

    public void setSnake(int snakeTail) {
        this.hasSnakeHead = true;
        this.snakeTail = snakeTail;
    }

    public void setLadder(int ladderEnd) {
        this.hasLadderStart = true;
        this.ladderEnd = ladderEnd;
    }

    public boolean doesLadderStart() {
        return hasLadderStart;
    }
    
    public int getLadderEnd() {
        return ladderEnd;
    }
    
    public boolean doesSnakeHeadStart() {
        return hasSnakeHead;
    }

    public int getSnakeTail() {
        return snakeTail;
    }
}