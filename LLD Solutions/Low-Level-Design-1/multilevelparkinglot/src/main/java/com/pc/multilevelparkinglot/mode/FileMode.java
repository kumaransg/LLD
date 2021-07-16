/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.mode;

import com.pc.multilevelparkinglot.OutputPrinter;
import com.pc.multilevelparkinglot.commands.CommandExecutorFactory;
import com.pc.multilevelparkinglot.exception.ParkingLotException;
import com.pc.multilevelparkinglot.model.Command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author paras.chawla
 * @version $Id: FileMode.java, v 0.1 2020-11-20 12:54 paras.chawla Exp $$
 */
public class FileMode extends Mode {
    private String fileName;

    public FileMode(CommandExecutorFactory commandExecutorFactory,
                    OutputPrinter outputPrinter, String fileName) {
        super(commandExecutorFactory, outputPrinter);
        this.fileName = fileName;
    }

    @Override
    public void process() throws IOException {
        outputPrinter.welcome();

        // file read
        File file = new File(fileName);
        final BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            outputPrinter.invalidFile();
            return;
        }

        String input = reader.readLine();
        while (input != null) {
            Command command = new Command(input);
            try {
                processCommand(command);
            } catch (ParkingLotException e) {
                e.printStackTrace();
            }
            input = reader.readLine();
        }

    }
}