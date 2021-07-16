/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.mode;

import com.pc.multilevelparkinglot.OutputPrinter;
import com.pc.multilevelparkinglot.commands.CommandExecutor;
import com.pc.multilevelparkinglot.commands.CommandExecutorFactory;
import com.pc.multilevelparkinglot.exception.InvalidCommandException;
import com.pc.multilevelparkinglot.exception.ParkingLotException;
import com.pc.multilevelparkinglot.model.Command;

import java.io.IOException;

/**
 * @author paras.chawla
 * @version $Id: Mode.java, v 0.1 2020-11-20 11:40 paras.chawla Exp $$
 */
abstract public class Mode {

    CommandExecutorFactory commandExecutorFactory;
    OutputPrinter          outputPrinter;

    public Mode(CommandExecutorFactory commandExecutorFactory, OutputPrinter outputPrinter) {
        this.commandExecutorFactory = commandExecutorFactory;
        this.outputPrinter = outputPrinter;
    }

    // Method to process the mode . Every mode has its own way of processing
    public abstract void process() throws IOException;

    // This method will remain same irrespective of Mode
    void processCommand(Command command) throws ParkingLotException {
        CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
        if (commandExecutor.validate(command)) {
            commandExecutor.execute(command);
        } else {
            throw new InvalidCommandException();
        }
    }
}