package com.calc;

public class AdditionCommand implements Command {
    private int operand;
    private Calculator calculator;

    public AdditionCommand(Calculator calculator, int operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    public void execute() {
        calculator.setShowVal(calculator.getShowVal() + operand);
    }

    public void undo() {
        (new SubtractionCommand(calculator, operand)).execute();
    }
}