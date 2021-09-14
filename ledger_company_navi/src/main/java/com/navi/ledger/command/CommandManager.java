package com.navi.ledger.command;

public class CommandManager {

    CommandFactory commandFactory = new CommandFactory();
    CommandExecution commandExecution;

    public void executeCommand(String input) {
        String[] inputSplit = input.split(" ");
        String command = inputSplit[0];
        commandExecution = commandFactory.getInstance(command,inputSplit);
        commandExecution.execute();
        }
}
