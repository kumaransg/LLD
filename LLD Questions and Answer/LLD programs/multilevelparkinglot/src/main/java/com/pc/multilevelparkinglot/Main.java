/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot;

import com.pc.multilevelparkinglot.commands.CommandExecutorFactory;
import com.pc.multilevelparkinglot.service.impl.ParkingServiceImpl;
import com.pc.multilevelparkinglot.exception.InvalidModeException;
import com.pc.multilevelparkinglot.mode.FileMode;
import com.pc.multilevelparkinglot.mode.InteractiveMode;
import com.pc.multilevelparkinglot.service.ParkingService;

import java.io.IOException;

/**
 * @author paras.chawla
 * @version $Id: Main.java, v 0.1 2020-11-20 11:21 paras.chawla Exp $$
 */
public class Main {

    public static void main(String[] args) throws IOException {
        final OutputPrinter outputPrinter = new OutputPrinter();
        final ParkingService parkingService = new ParkingServiceImpl();
        final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingService);

        if (isInteractiveMode(args)) {
            new InteractiveMode(commandExecutorFactory,outputPrinter).process();
        } else if (isFileInputMode(args)) {
            new FileMode(commandExecutorFactory,outputPrinter,args[0]).process();
        } else {
            throw new InvalidModeException();
        }
    }

    private static boolean isInteractiveMode(String[] args) {
        return args.length == 0;
    }

    private static boolean isFileInputMode(final String[] args) {
        return args.length == 1;
    }
}