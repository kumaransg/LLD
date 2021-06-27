/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.exception;

/**
 * @author paras.chawla
 * @version $Id: ParkingLotException.java, v 0.1 2020-11-20 00:56 paras.chawla Exp $$
 */
public class ParkingLotException extends Exception {

    public ParkingLotException() {
        super();
    }

    public ParkingLotException(String message) {
        super(message);
    }

    public ParkingLotException(Throwable cause) {
        super(cause);
    }

    public ParkingLotException(String message, Throwable cause) {
        super(message, cause);
    }
}