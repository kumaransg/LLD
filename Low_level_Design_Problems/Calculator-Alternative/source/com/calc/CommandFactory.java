package com.calc;

public class CommandFactory {
    private Calculator calculator;
    public CommandFactory(Calculator calculator) {
        this.calculator = calculator;
    }

    public Command createCommand(String operator, int operand) {
        Command command = null;

        switch(operator) {
            case "+": command = new AdditionCommand(calculator, operand);
                    break;
            case "-": command = new SubtractionCommand(calculator, operand);
                    break;
            case "*": command = new MultiplicationCommand(calculator, operand);
                    break;
            case "/": command = new DivisionCommand(calculator, operand);
                    break;
            case "pow": command = new PowerCommand(calculator, operand);
                    break;
        }
        return command;
    }
}