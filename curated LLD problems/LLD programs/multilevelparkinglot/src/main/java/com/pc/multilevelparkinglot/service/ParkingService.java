/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.service;

import com.pc.multilevelparkinglot.exception.ParkingLotException;
import com.pc.multilevelparkinglot.model.Vehicle;
import com.pc.multilevelparkinglot.model.ParkingLot;

/**
 * @author paras.chawla
 * @version $Id: ParkingService.java, v 0.1 2020-11-13 00:50 paras.chawla Exp $$
 */

public interface ParkingService extends AbstractService {

    ParkingLot createParkingLot(int level, int capacity) throws ParkingLotException;

    Integer parkVehicle(int level, Vehicle vehicle) throws ParkingLotException;

    boolean unparkVehicle(int level, Integer slotNumber) throws ParkingLotException;

}