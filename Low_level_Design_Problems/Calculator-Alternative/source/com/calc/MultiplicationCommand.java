package com.calc;

public class MultiplicationCommand implements Command {
    private int operand;
    private Calculator calculator;

    public MultiplicationCommand(Calculator calculator, int operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    public void execute() {
        calculator.setShowVal(calculator.getShowVal() * operand);
    }

    public void undo() {
        (new DivisionCommand(calculator, operand)).execute();
    }
}