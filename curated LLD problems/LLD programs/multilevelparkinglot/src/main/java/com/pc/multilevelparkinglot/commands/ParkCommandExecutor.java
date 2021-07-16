/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.commands;

import com.pc.multilevelparkinglot.OutputPrinter;
import com.pc.multilevelparkinglot.constant.ParkingConstants;
import com.pc.multilevelparkinglot.exception.ParkingLotException;
import com.pc.multilevelparkinglot.model.Car;
import com.pc.multilevelparkinglot.model.Command;
import com.pc.multilevelparkinglot.service.ParkingService;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author paras.chawla
 * @version $Id: CreateParkingLotCommandExecutor.java, v 0.1 2020-11-20 10:35 paras.chawla Exp $$
 */
@NoArgsConstructor
public class ParkCommandExecutor extends CommandExecutor {

    public static String COMMAND_NAME = "park";

    public ParkCommandExecutor(ParkingService parkingService,
                               OutputPrinter outputPrinter) {
        super(parkingService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        List<String> params = command.getParams();
        if (params.size() != 2) {
            return false;
        }
        return params.size() == 2;
    }

    @Override
    public void execute(Command command) throws ParkingLotException {
        Car car = new Car(command.getParams().get(0), command.getParams().get(1));

        final Integer slotNumber = parkingService.parkVehicle(1, car);

        if (slotNumber == ParkingConstants.NOT_AVAILABLE) {
            outputPrinter.parkingLotFull();
        } else if (slotNumber == ParkingConstants.VEHICLE_ALREADY_PARKED) {
            outputPrinter.printWithNewLine("Sorry, Vehicle is already parked");
        } else {
            outputPrinter.printWithNewLine("Allocated slot number" + slotNumber);
        }
    }
}