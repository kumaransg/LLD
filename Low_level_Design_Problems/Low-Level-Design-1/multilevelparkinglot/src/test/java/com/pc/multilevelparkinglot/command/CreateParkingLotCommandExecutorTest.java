/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.command;

import com.pc.multilevelparkinglot.OutputPrinter;
import com.pc.multilevelparkinglot.commands.CreateParkingLotCommandExecutor;
import com.pc.multilevelparkinglot.exception.ParkingLotException;
import com.pc.multilevelparkinglot.model.Command;
import com.pc.multilevelparkinglot.model.ParkingLot;
import com.pc.multilevelparkinglot.service.ParkingService;
import com.pc.multilevelparkinglot.service.impl.ParkingServiceImpl;
import com.pc.multilevelparkinglot.strategy.impl.NearestParkingStrategy;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * @author paras.chawla
 * @version $Id: CreateParkingLotCommandExecutorTest.java, v 0.1 2020-11-20 15:20 paras.chawla Exp $$
 */
public class CreateParkingLotCommandExecutorTest {

    private ParkingService                  parkingLotService;
    private OutputPrinter                   outputPrinter;
    private CreateParkingLotCommandExecutor createParkingLotCommandExecutor;

    @Before
    public void setUp() throws Exception {
        parkingLotService = mock(ParkingServiceImpl.class);
        outputPrinter = mock(OutputPrinter.class);
        createParkingLotCommandExecutor =
                new CreateParkingLotCommandExecutor(parkingLotService, outputPrinter);
    }

    @Test
    public void testValidCommand() {
        org.junit.Assert.assertTrue(createParkingLotCommandExecutor.validate(new Command("create_parking_lot 6")));
    }

    @Test
    public void testInvalidCommand() {
        org.junit.Assert.assertFalse(createParkingLotCommandExecutor.validate(new Command("create_parking_lot")));
        org.junit.Assert.assertFalse(createParkingLotCommandExecutor.validate(new Command("create_parking_lot abcd")));
    }

    @Test
    public void testCommandExecution() throws ParkingLotException {
        createParkingLotCommandExecutor.execute(new Command("create_parking_lot 6"));

        final ArgumentCaptor<ParkingLot> argument = ArgumentCaptor.forClass(ParkingLot.class);
        //verify(parkingLotService)
          //      .createParkingLot(argument.capture(), any(NearestParkingStrategy.class));
        org.junit.Assert.assertEquals(6, argument.getValue().getSlots());
        verify(outputPrinter).printWithNewLine("Created a parking lot with 6 slots");
    }
}