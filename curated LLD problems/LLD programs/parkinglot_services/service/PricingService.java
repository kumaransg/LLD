/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package parkinglot_services.service;

import parkinglot_services.models.VehicleType;

import java.util.Date;

/**
 * @author paras.chawla
 * @version $Id: PricingService.java, v 0.1 2020-05-18 20:12 paras.chawla Exp $$
 */
public interface PricingService {

    // calculate parking price when user exit
    double calculatePrice(VehicleType vehicleType, Date entryTime, Date exitTime);
}