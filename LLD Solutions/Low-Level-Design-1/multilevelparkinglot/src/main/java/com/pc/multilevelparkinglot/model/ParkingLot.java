/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author paras.chawla
 * @version $Id: ParkingLot.java, v 0.1 2020-11-13 00:52 paras.chawla Exp $$
 */

@Getter
@Setter
public class ParkingLot {

    private String parkingId;
    private int levels;
    private int slots;

}