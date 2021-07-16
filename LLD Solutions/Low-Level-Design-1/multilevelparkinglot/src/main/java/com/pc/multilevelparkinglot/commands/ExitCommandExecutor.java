/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.commands;

import com.pc.multilevelparkinglot.OutputPrinter;
import com.pc.multilevelparkinglot.exception.ParkingLotException;
import com.pc.multilevelparkinglot.model.Command;
import com.pc.multilevelparkinglot.service.ParkingService;
import lombok.NoArgsConstructor;

/**
 * @author paras.chawla
 * @version $Id: CreateParkingLotCommandExecutor.java, v 0.1 2020-11-20 10:35 paras.chawla Exp $$
 */
@NoArgsConstructor
public class ExitCommandExecutor extends CommandExecutor {

    public static String COMMAND_NAME = "exit";

    public ExitCommandExecutor(ParkingService parkingService,
                               OutputPrinter outputPrinter) {
        super(parkingService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 0;
    }

    @Override
    public void execute(Command command) throws ParkingLotException {
    }
}