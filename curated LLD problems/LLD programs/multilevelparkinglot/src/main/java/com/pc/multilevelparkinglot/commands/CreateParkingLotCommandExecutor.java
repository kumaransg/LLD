/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.commands;

import com.pc.multilevelparkinglot.OutputPrinter;
import com.pc.multilevelparkinglot.exception.ParkingLotException;
import com.pc.multilevelparkinglot.model.Command;
import com.pc.multilevelparkinglot.model.ParkingLot;
import com.pc.multilevelparkinglot.service.ParkingService;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author paras.chawla
 * @version $Id: CreateParkingLotCommandExecutor.java, v 0.1 2020-11-20 10:35 paras.chawla Exp $$
 */
@NoArgsConstructor
public class CreateParkingLotCommandExecutor extends CommandExecutor {

    public static String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(ParkingService parkingService,
                                           OutputPrinter outputPrinter) {
        super(parkingService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        List<String> params = command.getParams();
        if (params.size() != 1) {
            return false;
        }
        return params.size() == 1;
    }

    @Override
    public void execute(Command command) throws ParkingLotException {
        int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
        ParkingLot lot = parkingService.createParkingLot(1, parkingLotCapacity);
        outputPrinter.printWithNewLine("Created a parking lot with " + lot.getSlots() + " slots ");
    }
}