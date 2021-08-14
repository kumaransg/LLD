/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.mode;

import com.pc.multilevelparkinglot.OutputPrinter;
import com.pc.multilevelparkinglot.commands.CommandExecutorFactory;
import com.pc.multilevelparkinglot.exception.ParkingLotException;
import com.pc.multilevelparkinglot.model.Command;
import com.pc.multilevelparkinglot.commands.ExitCommandExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author paras.chawla
 * @version $Id: InteractiveMode.java, v 0.1 2020-11-20 11:44 paras.chawla Exp $$
 */
public class InteractiveMode extends Mode {

    public InteractiveMode(CommandExecutorFactory commandExecutorFactory,
                           OutputPrinter outputPrinter) {
        super(commandExecutorFactory, outputPrinter);
    }

    @Override
    public void process() throws IOException {
        outputPrinter.welcome();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String inputLine = reader.readLine();
            Command command = new Command(inputLine);
            try {
                processCommand(command);
            } catch (ParkingLotException e) {
                e.printStackTrace();
            }
            // Exit the process
            if (command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
                break;
            }
        }
    }
}