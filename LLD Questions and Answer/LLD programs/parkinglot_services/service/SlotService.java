/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package parkinglot_services.service;

import parkinglot_services.models.ParkingSlot;
import parkinglot_services.models.VehicleType;

/**
 * @author paras.chawla
 * @version $Id: SlotService.java, v 0.1 2020-05-18 20:09 paras.chawla Exp $$
 */

/* > potential Concurrency issue if (More than one entry/exit is possible)
   > 2 Vehicles entrying from different entry point, system can pottentially create
   same slot if lock isn't taken
   > Query to find available slots
   > pick slot to allocate
   > try lock on slot. If unavailable, wait. If fails, pick another slot
   > Assign slot to vehicle, make it occupied
   > Unlock the slot
 */
public interface SlotService {

    // allocate parkingSlot to a particular vehicle
    ParkingSlot allocate(VehicleType vehicleType);

    // unallocate parkingSlot based on parkingSlotId
    boolean unallocate(long parkingSlotId);
}