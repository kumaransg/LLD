/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.dao;

import com.pc.multilevelparkinglot.model.Vehicle;

import java.util.List;

/**
 * @author paras.chawla
 * @version $Id: ParkingLevelDao.java, v 0.1 2020-11-18 18:30 paras.chawla Exp $$
 * Include methods involving level based
 */
public interface ParkingLevelDao<T extends Vehicle> {

    // give SlotNumber in return
    int parkVehicle(T vehicle);

    // whether its success or fail
    boolean leaveVehicle(int slotNumber);

    // Status of current level
    List<String> getStatus();

    // cleanup of what is already set
    void doCleanUp();

}