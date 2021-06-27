/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package parkinglot_services.service;

import parkinglot_services.models.Ticket;
import parkinglot_services.models.VehicleType;

/**
 * @author paras.chawla
 * @version $Id: ParkingService.java, v 0.1 2020-05-18 20:02 paras.chawla Exp $$
 */
interface ParkingService {

    // use SlotService to assign slot and return ticket
    Ticket entry(VehicleType vehicleType);

    // use PricingService to calculate ticket price based on ticketId
    double exit(long ticketId); // return price
}