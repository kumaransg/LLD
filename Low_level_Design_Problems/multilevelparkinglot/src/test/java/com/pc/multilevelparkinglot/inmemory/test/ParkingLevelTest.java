/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.inmemory.test;

import com.pc.multilevelparkinglot.exception.ParkingLotException;
import com.pc.multilevelparkinglot.strategy.impl.NearestParkingStrategy;
import com.pc.multilevelparkinglot.constant.ParkingConstants;
import com.pc.multilevelparkinglot.dao.ParkingLevelDao;
import com.pc.multilevelparkinglot.db.manager.InMemoryParkingLevelManager;
import com.pc.multilevelparkinglot.model.Car;
import com.pc.multilevelparkinglot.model.Vehicle;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author paras.chawla
 * @version $Id: ParkingLevelTest.java, v 0.1 2020-11-20 13:36 paras.chawla Exp $$
 */
public class ParkingLevelTest {

    private static final int level = 1;
    private static ParkingLevelDao<Vehicle> parkingLevelDao;

    @BeforeClass
    public static void init(){
        parkingLevelDao = new InMemoryParkingLevelManager(level,6,new NearestParkingStrategy());
        parkingLevelDao.parkVehicle(new Car("KA-01-HH-1233", "white"));
    }

    @Test
    public void testParkSecondVehicle(){
        org.junit.Assert.assertTrue(parkingLevelDao.parkVehicle(new Car("HR12Z5217","Black"))==2);
    }

    @Test
    public void testVehicleAlreadyExist(){
        assertTrue(parkingLevelDao.parkVehicle(new Car("KA-01-HH-1233", "white")) == ParkingConstants.VEHICLE_ALREADY_PARKED);
    }

    @Test
    public void t03_testVehicleNotAvailable() throws ParkingLotException
    {
        parkingLevelDao.parkVehicle(new Car("KA-01-HH-1234", "green"));
        parkingLevelDao.parkVehicle(new Car("KA-01-HH-1235", "white"));
        parkingLevelDao.parkVehicle(new Car("KA-01-HH-1236", "white"));
        parkingLevelDao.parkVehicle(new Car("KA-01-HH-1237", "white"));
        assertTrue(parkingLevelDao.parkVehicle(new Car("KA-01-HH-1233", "white")) == ParkingConstants.NOT_AVAILABLE);
    }

    @Test
    public void t05_leaveVehicle() throws ParkingLotException
    {
        assertTrue(parkingLevelDao.leaveVehicle(6));
    }
}