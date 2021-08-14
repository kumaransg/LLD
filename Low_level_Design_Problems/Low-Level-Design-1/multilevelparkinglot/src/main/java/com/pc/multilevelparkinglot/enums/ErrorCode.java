/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.enums;

/**
 * @author paras.chawla
 * @version $Id: ErrorCode.java, v 0.1 2020-11-13 00:31 paras.chawla Exp $$
 */
public enum ErrorCode {

    PARKING_ALREADY_EXIST("Sorry, Parking Already exist, can't recreate again"),
    PARKING_NOT_EXIST_ERROR("Sorry, Parking doesn't exist");

    ErrorCode(String message) {this.message = message;}

    private String message = "";

}