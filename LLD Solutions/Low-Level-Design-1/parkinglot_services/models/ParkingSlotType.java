/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package parkinglot_services.models;

/**
 * @author paras.chawla
 * @version $Id: ParkingSlotType.java, v 0.1 2020-05-18 21:21 paras.chawla Exp $$
 */
public enum ParkingSlotType {
    COMPACT(2),
    LARGE(5),
    MOTORBIKE(1);

    int slotSize;

    ParkingSlotType(int slotSize) {
        this.slotSize = slotSize;
    }
}