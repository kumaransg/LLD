package com.calc;

public class Calculator {
    private int showVal;

    public Calculator() {
        this.showVal = 0;
    }

    public Calculator(int showVal) {
        this.showVal = showVal;
    }

    public int getShowVal() {
        return showVal;
    }

    public void action(String operator, int operand) {
        switch(operator) {
            case "+": 
                showVal += operand;
                break;
            case "-": 
                showVal -= operand;
                break;
            case "*": 
                showVal *= operand;
                break;
            case "/": 
                showVal /= operand;
                break;
        }
    }
}