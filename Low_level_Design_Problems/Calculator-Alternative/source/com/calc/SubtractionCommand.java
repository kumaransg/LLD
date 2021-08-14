package com.calc;

public class SubtractionCommand implements Command {
    private int operand;
    private Calculator calculator;

    public SubtractionCommand(Calculator calculator, int operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    public void execute() {
        calculator.setShowVal(calculator.getShowVal() - operand);
    }

    public void undo() {
        (new AdditionCommand(calculator, operand)).execute();
    }
}