/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package parkinglot_services.models;

import java.util.Date;

/**
 * @author paras.chawla
 * @version $Id: Ticket.java, v 0.1 2020-05-18 19:57 paras.chawla Exp $$
 */
public class Ticket {

    long        ticketId;
    ParkingSlot parkingSlot;
    Date        entryTime, exitTime;
    String vehicleNumber;
}