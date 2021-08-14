/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.db.manager;

import com.pc.multilevelparkinglot.dao.ParkingLevelDao;
import com.pc.multilevelparkinglot.model.Vehicle;
import com.pc.multilevelparkinglot.strategy.ParkingStrategy;
import com.pc.multilevelparkinglot.dao.ParkingDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author paras.chawla
 * @version $Id: InMemoryParkingManager.java, v 0.1 2020-11-18 18:55 paras.chawla Exp $$ global Parking manager managing parking lot level
 * by level
 */
public class InMemoryParkingManager implements ParkingDao<Vehicle> {

    // Key - Level , Value - ParkingLevelDao
    Map<Integer, ParkingLevelDao<Vehicle>> levelParkingMap;

    public InMemoryParkingManager(List<Integer> parkingLevels, List<Integer> capacityList,
                                  List<ParkingStrategy> parkingStrategies) {
        if (levelParkingMap == null) { this.levelParkingMap = new HashMap<>(); }

        for (int i = 0; i < parkingLevels.size(); i++) {
            levelParkingMap.put(parkingLevels.get(i), new InMemoryParkingLevelManager(parkingLevels.get(i),
                    capacityList.get(i), parkingStrategies.get(i)));
        }
    }

    @Override
    public int parkVehicle(int level, Vehicle vehicle) {
        return levelParkingMap.get(level).parkVehicle(vehicle);
    }

    @Override
    public boolean leaveVehicle(int level, int slotNumber) {
        return levelParkingMap.get(level).leaveVehicle(slotNumber);
    }

    @Override
    public List<String> getStatus(int level) {
        return levelParkingMap.get(level).getStatus();
    }

    @Override
    public void doCleanUp() {
        for (Map.Entry<Integer, ParkingLevelDao<Vehicle>> parkingLevel : levelParkingMap.entrySet()) {
            parkingLevel.getValue().doCleanUp();
        }
        levelParkingMap = new HashMap<>();
    }
}