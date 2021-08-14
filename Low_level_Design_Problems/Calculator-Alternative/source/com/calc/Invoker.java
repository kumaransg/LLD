package com.calc;

import java.util.*;

public class Invoker {
    Stack<Command> commands;

    public Invoker() {
        commands = new Stack<Command>();
    }

    public void compute(Command command) {
        command.execute();
        commands.push(command);
    }

    public void undo() {
        if(!commands.isEmpty()) {
            commands.pop().undo();
        }
    }
}