package com.calc;

public class PowerCommand implements Command {
    private int operand;
    private Calculator calculator;

    public PowerCommand(Calculator calculator, int operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    public void execute() {
        calculator.setShowVal((int) Math.pow(calculator.getShowVal(), operand));
    }

    public void undo() {
        double logA = Math.log(calculator.getShowVal());
        double logB = Math.log(operand);
        calculator.setShowVal((int)(logA/logB));
    }
}