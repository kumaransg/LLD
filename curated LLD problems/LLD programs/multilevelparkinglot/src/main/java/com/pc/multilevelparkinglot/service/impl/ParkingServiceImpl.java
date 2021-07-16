/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.service.impl;

import com.pc.multilevelparkinglot.strategy.ParkingStrategy;
import com.pc.multilevelparkinglot.constant.ParkingConstants;
import com.pc.multilevelparkinglot.dao.ParkingDao;
import com.pc.multilevelparkinglot.db.manager.InMemoryParkingManager;
import com.pc.multilevelparkinglot.exception.ParkingLotException;
import com.pc.multilevelparkinglot.model.ParkingLot;
import com.pc.multilevelparkinglot.model.Vehicle;
import com.pc.multilevelparkinglot.service.ParkingService;
import com.pc.multilevelparkinglot.strategy.impl.NearestParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author paras.chawla
 * @version $Id: ParkingServiceImpl.java, v 0.1 2020-11-13 09:19 paras.chawla Exp $$
 */
public class ParkingServiceImpl implements ParkingService {

    private ParkingDao<Vehicle> parkingDao = null;

    // Assuming every level has same capacity and strategy
    @Override
    public ParkingLot createParkingLot(int level, int capacity) throws ParkingLotException {
        List<Integer> parkingLevels = new ArrayList<>();
        parkingLevels.add(level);

        List<Integer> capacityList = new ArrayList<>();
        capacityList.add(capacity);

        List<ParkingStrategy> parkingStrategies = new ArrayList<>();
        parkingStrategies.add(new NearestParkingStrategy());
        if (parkingDao != null) {
            throw new ParkingLotException(ParkingConstants.PARKING_ALREADY_EXIST);
        }
        this.parkingDao = new InMemoryParkingManager(parkingLevels, capacityList, parkingStrategies);

        ParkingLot lot = new ParkingLot();
        lot.setParkingId(UUID.randomUUID().toString());
        lot.setSlots(capacity);
        return lot;
    }

    @Override
    public Integer parkVehicle(int level, Vehicle vehicle) throws ParkingLotException {
        int value = -1;
        validateParkingLot();
        try {
            value = parkingDao.parkVehicle(level, vehicle);
        } catch (Exception e) {
            throw new ParkingLotException(ParkingConstants.PROCESSING_ERROR, e);
        }
        return value;
    }

    @Override
    public boolean unparkVehicle(int level, Integer slotNumber) throws ParkingLotException {
        validateParkingLot();
        try {
            return parkingDao.leaveVehicle(level, slotNumber);
        } catch (Exception e) {
            throw new ParkingLotException();
        }
    }

    private void validateParkingLot() throws ParkingLotException {
        if (parkingDao == null) {
            throw new ParkingLotException(ParkingConstants.PARKING_NOT_EXIST_ERROR);
        }
    }

}