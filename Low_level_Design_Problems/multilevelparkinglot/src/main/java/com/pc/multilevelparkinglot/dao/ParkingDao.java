/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.dao;

import com.pc.multilevelparkinglot.model.Vehicle;

import java.util.List;

/**
 * @author paras.chawla
 * @version $Id: ParkingLevelDao.java, v 0.1 2020-11-18 18:30 paras.chawla Exp $$
 * Global Parking DAO class which handles all levels
 */
public interface ParkingDao<T extends Vehicle> {

    // give SlotNumber in return
    int parkVehicle(int level, T vehicle);

    // whether its success or fail
    boolean leaveVehicle(int level, int slotNumber);

    // Status of current level
    List<String> getStatus(int level);

    // cleanup all level inmemory data
    void doCleanUp();

}