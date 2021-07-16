/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.model;

/**
 * @author paras.chawla
 * @version $Id: Vehicle.java, v 0.1 2020-11-13 00:22 paras.chawla Exp $$
 */
public abstract class Vehicle {

    private String licensePlateNo = null;
    private String color = null;

    public Vehicle(String licensePlateNo, String color) {
        this.licensePlateNo = licensePlateNo;
        this.color = color;
    }

    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public void setLicensePlateNo(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}