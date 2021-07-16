/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.commands;

import com.pc.multilevelparkinglot.OutputPrinter;
import com.pc.multilevelparkinglot.exception.InvalidCommandException;
import com.pc.multilevelparkinglot.model.Command;
import com.pc.multilevelparkinglot.service.ParkingService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author paras.chawla
 * @version $Id: CommandExecutorFactory.java, v 0.1 2020-11-20 10:32 paras.chawla Exp $$
 */

// Factory class to fetch Correct Command Executor based on input command
public class CommandExecutorFactory {

    // K - Command , V - CommandExecutor
    private static Map<String, CommandExecutor> commands = new HashMap<>();

    public CommandExecutorFactory(final ParkingService parkingLotService) {
        final OutputPrinter outputPrinter = new OutputPrinter();
        commands.put(
                CreateParkingLotCommandExecutor.COMMAND_NAME,
                new CreateParkingLotCommandExecutor(parkingLotService, outputPrinter));
        commands.put(
                ParkCommandExecutor.COMMAND_NAME,
                new ParkCommandExecutor(parkingLotService, outputPrinter));
        commands.put(
                LeaveCommandExecutor.COMMAND_NAME,
                new LeaveCommandExecutor(parkingLotService, outputPrinter));
        commands.put(
                ExitCommandExecutor.COMMAND_NAME,
                new ExitCommandExecutor(parkingLotService, outputPrinter));
    }

    public CommandExecutor getCommandExecutor(Command command) {
        final CommandExecutor commandExecutor = commands.get(command.getCommandName());
        if (commandExecutor == null) {
            throw new InvalidCommandException();
        }
        return commandExecutor;
    }

}