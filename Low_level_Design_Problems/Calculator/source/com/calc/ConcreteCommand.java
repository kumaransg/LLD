package com.calc;

public class ConcreteCommand implements Command {
    private Calculator calculator;
    private String operator;
    private int operand;

    public ConcreteCommand(Calculator calculator, String operator, int operand) {
        this.calculator = calculator;
        this.operator = operator;
        this.operand = operand;
    }

    public void execute() {
        calculator.action(operator, operand);
    }

    public void unexecute() {
        calculator.action(undo(operator), operand);
    }

    private String undo(String operator) {
        switch(operator) {
            case "+": return "-";
            case "-": return "+";
            case "*": return "/";
            case "/": return "*";
        }
        return null;
    }
}