package com.system.design.oops.amazon;

import java.util.Date;

public class Shipment {
    private String shipmentNumber;
    private Date shipmentDate;
    private Date estimatedArrival;
    private String shipmentMethod;

    public boolean addShipmentLog(ShipmentLog shipmentLog){ return true;}
}
