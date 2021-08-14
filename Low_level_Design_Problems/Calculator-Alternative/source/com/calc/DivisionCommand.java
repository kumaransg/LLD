package com.calc;

public class DivisionCommand implements Command {
    private int operand;
    private Calculator calculator;

    public DivisionCommand(Calculator calculator, int operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    public void execute() {
        calculator.setShowVal(calculator.getShowVal() / operand);
    }

    public void undo() {
        (new MultiplicationCommand(calculator, operand)).execute();
    }
}