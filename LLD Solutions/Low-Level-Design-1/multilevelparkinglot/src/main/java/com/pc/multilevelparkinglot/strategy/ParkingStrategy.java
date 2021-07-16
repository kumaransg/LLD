/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.strategy;

/**
 * @author paras.chawla
 * @version $Id: ParkingStrategy.java, v 0.1 2020-11-13 00:24 paras.chawla Exp $$
 */
public interface ParkingStrategy {

    // when creating a parkinglot
    public void add(int i);

    // when a park comes and we need to give a slot from available slots
    public int getSlot();

    // when a car get slot, need to remove slot
    public void removeSlot(int slot);

}