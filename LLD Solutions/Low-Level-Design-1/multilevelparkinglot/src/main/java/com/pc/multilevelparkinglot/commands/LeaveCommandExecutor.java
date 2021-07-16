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
public class LeaveCommandExecutor extends CommandExecutor {

    public static String COMMAND_NAME = "leave";

    public LeaveCommandExecutor(ParkingService parkingService,
                                OutputPrinter outputPrinter) {
        super(parkingService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public void execute(Command command) throws ParkingLotException {
        int slotNumber = Integer.parseInt(command.getParams().get(0));
        if (parkingService.unparkVehicle(1, slotNumber)) {
            outputPrinter.printWithNewLine("Slot number " + slotNumber + " is free now");
        } else {
            outputPrinter.printWithNewLine("Slot number " + slotNumber + "is already empty");
        }
    }
}