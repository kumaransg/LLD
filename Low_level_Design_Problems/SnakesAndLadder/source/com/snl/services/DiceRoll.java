package com.snl.services;

public class DiceRoll {
    public static int rollDice() {
        return (((int) (Math.random() * 6)) + 1);
    }
}