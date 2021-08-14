package com.calc;

public class CalculatorTest {
    public static void main(String[] args) {
        Invoker user = new Invoker();
        Calculator calculator = new Calculator();
        System.out.println("Calculator Display Initially: " + calculator.getShowVal());

        Command command = new ConcreteCommand(calculator, "+", 5);
        user.compute(command);
        System.out.println("Calculator Display after Command: " + calculator.getShowVal());

        command = new ConcreteCommand(calculator, "-", 2);
        user.compute(command);
        System.out.println("Calculator Display after Command: " + calculator.getShowVal());

        command = new ConcreteCommand(calculator, "*", 4);
        user.compute(command);
        System.out.println("Calculator Display after Command: " + calculator.getShowVal());

        command = new ConcreteCommand(calculator, "/", 3);
        user.compute(command);
        System.out.println("Calculator Display after Command: " + calculator.getShowVal());

        user.undo();
        System.out.println("Calculator Display after Undo: " + calculator.getShowVal());

        user.undo();
        System.out.println("Calculator Display after Undo: " + calculator.getShowVal());

        user.undo();
        System.out.println("Calculator Display after Undo: " + calculator.getShowVal());

        user.undo();
        System.out.println("Calculator Display after Undo: " + calculator.getShowVal());
    }
}