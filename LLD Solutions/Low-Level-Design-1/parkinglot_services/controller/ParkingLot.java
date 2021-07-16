/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package parkinglot_services.controller;

import parkinglot_services.models.ParkingSlot;
import parkinglot_services.models.ParkingSlotType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author paras.chawla
 * @version $Id: ParkingLot.java, v 0.1 2020-05-23 23:53 paras.chawla Exp $$
 */

/*Singleton class having single parkingLot instance which instantiates all slots*/
public class ParkingLot {

    private static ParkingLot lot = null;

    private static final int NUMBER_OF_SMALL_SLOTS   = 10;
    private static final int NUMBER_OF_COMPACT_SLOTS = 10;
    private static final int NUMBER_OF_LARGE_SLOTS   = 10;

    private Map<Integer, ParkingSlot> occupiedSlots;
    private List<ParkingSlot>         smallSlots;
    private List<ParkingSlot>         compactSlots;
    private List<ParkingSlot>         largeSlots;

    private ParkingLot() {
        smallSlots = new LinkedList<>();
        compactSlots = new LinkedList<>();
        largeSlots = new LinkedList<>();
        occupiedSlots = new HashMap<>();
        for (int i = 1; i <= NUMBER_OF_SMALL_SLOTS; i++) { smallSlots.add(new ParkingSlot(i, ParkingSlotType.MOTORBIKE)); }

        for (int i = 1; i <= NUMBER_OF_COMPACT_SLOTS; i++) { compactSlots.add(new ParkingSlot(i, ParkingSlotType.COMPACT)); }

        for (int i = 1; i <= NUMBER_OF_LARGE_SLOTS; i++) { largeSlots.add(new ParkingSlot(i, ParkingSlotType.LARGE)); }

    }

    public List<ParkingSlot> getSmallSlots() {
        return smallSlots;
    }

    public List<ParkingSlot> getCompactSlots() {
        return compactSlots;
    }

    public List<ParkingSlot> getLargeSlots() {
        return largeSlots;
    }

    public static ParkingLot getInstance() {
        if (lot == null) { lot = new ParkingLot(); }
        return lot;
    }

    public Map<Integer, ParkingSlot> getOccupiedSlots() {
        return occupiedSlots;
    }
}