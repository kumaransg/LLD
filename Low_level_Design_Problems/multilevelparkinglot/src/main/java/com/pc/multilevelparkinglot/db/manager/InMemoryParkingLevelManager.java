/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.db.manager;

import com.pc.multilevelparkinglot.constant.ParkingConstants;
import com.pc.multilevelparkinglot.dao.ParkingLevelDao;
import com.pc.multilevelparkinglot.model.Vehicle;
import com.pc.multilevelparkinglot.strategy.ParkingStrategy;
import com.pc.multilevelparkinglot.strategy.impl.NearestParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author paras.chawla
 * @version $Id: InMemoryParkingLevelManager.java, v 0.1 2020-11-18 18:35 paras.chawla Exp $$ Denotes current level of parking lot
 */
public class InMemoryParkingLevelManager implements ParkingLevelDao<Vehicle> {

    AtomicInteger                   level       = new AtomicInteger(0);
    AtomicInteger                   capacity    = new AtomicInteger();
    AtomicInteger                   availablity = new AtomicInteger();
    ParkingStrategy                 parkingStrategy;
    Map<Integer, Optional<Vehicle>> slotVehicleMap;

    public InMemoryParkingLevelManager(int level, int capacity,
                                       ParkingStrategy parkingStrategy) {
        this.level.set(level);
        this.capacity.set(capacity);
        this.availablity.set(capacity);
        if (parkingStrategy == null) {
            this.parkingStrategy = new NearestParkingStrategy();
        }else{
            this.parkingStrategy=parkingStrategy;
        }
        slotVehicleMap = new ConcurrentHashMap<>();

        // fill map with empty Optional vehicle
        for (int i = 1; i <= capacity; i++) {
            slotVehicleMap.put(i, Optional.empty());
            parkingStrategy.add(i);
        }

    }

    @Override
    public int parkVehicle(Vehicle vehicle) {

        // 1. check parking availablity
        if (availablity.get() == 0) {
            return ParkingConstants.NOT_AVAILABLE;
        }

        // 2. check vehicle in slotMap if already exist
        if (slotVehicleMap.containsValue(Optional.of(vehicle))) {
            return ParkingConstants.VEHICLE_ALREADY_PARKED;
        }

        // 3. get freeslot and park vehicle to that particular slot
        int availableSlot = parkingStrategy.getSlot();
        slotVehicleMap.put(availableSlot, Optional.of(vehicle));
        this.availablity.decrementAndGet();
        parkingStrategy.removeSlot(availableSlot);
        return availableSlot;
    }

    @Override
    public boolean leaveVehicle(int slotNumber) {

        // 1. check if slot already empty
        if (!slotVehicleMap.get(slotNumber).isPresent()) {
            return false;
        }
        parkingStrategy.add(slotNumber);
        this.availablity.incrementAndGet();
        slotVehicleMap.remove(slotNumber);
        return true;
    }

    // Get status of all vehicles in current parking level
    @Override
    public List<String> getStatus() {

        List<String> statusList = new ArrayList<>();
        for (int i = 1; i <= capacity.get(); i++) {
            Optional<Vehicle> vehicle = slotVehicleMap.get(i);
            if (vehicle.isPresent()) {
                statusList.add(i + "\t\t" + vehicle.get().getLicensePlateNo() + "\t\t" + vehicle.get().getColor());
            }
        }
        return statusList;
    }

    @Override
    public void doCleanUp() {
        this.level = new AtomicInteger();
        this.capacity = new AtomicInteger();
        this.availablity = new AtomicInteger();
        this.parkingStrategy = null;
        this.slotVehicleMap = new ConcurrentHashMap<>();
    }

}