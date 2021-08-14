/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.strategy.impl;

import com.pc.multilevelparkinglot.strategy.ParkingStrategy;

import java.util.TreeSet;

/**
 * @author paras.chawla
 * @version $Id: NearestParkingStrategy.java, v 0.1 2020-11-13 00:28 paras.chawla Exp $$
 */
public class NearestParkingStrategy implements ParkingStrategy {

    private TreeSet<Integer> freeSlots;

    public NearestParkingStrategy() {
        this.freeSlots = new TreeSet<>();
    }

    @Override
    public void add(int i) {
        freeSlots.add(i);
    }

    @Override
    public int getSlot() {
        return freeSlots.first();
    }

    @Override
    public void removeSlot(int availableSlot) {
        freeSlots.remove(availableSlot);
    }
}