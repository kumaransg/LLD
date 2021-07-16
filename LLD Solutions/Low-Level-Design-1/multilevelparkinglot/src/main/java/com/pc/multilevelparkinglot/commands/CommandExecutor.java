/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.commands;

import com.pc.multilevelparkinglot.exception.ParkingLotException;
import com.pc.multilevelparkinglot.model.Command;
import com.pc.multilevelparkinglot.OutputPrinter;
import com.pc.multilevelparkinglot.service.ParkingService;
import lombok.NoArgsConstructor;

/**
 * @author paras.chawla
 * @version $Id: CommandExecutor.java, v 0.1 2020-11-20 10:27 paras.chawla Exp $$ Command Executor Interface All other Commands will extend
 * CommandExecutor
 */
@NoArgsConstructor
public abstract class CommandExecutor<T extends Command> {

    // Every commandExecutor need parkingService and OutputPrinter
    protected ParkingService parkingService;
    protected OutputPrinter  outputPrinter;

    public CommandExecutor(ParkingService parkingService, OutputPrinter outputPrinter) {
        this.parkingService = parkingService;
        this.outputPrinter = outputPrinter;
    }

    // Validate whether command is valid or not
    public abstract boolean validate(T command);

    // execute the command
    public abstract void execute(T command) throws ParkingLotException;
}