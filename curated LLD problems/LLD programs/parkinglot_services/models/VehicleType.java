/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package parkinglot_services.models;

/**
 * @author paras.chawla
 * @version $Id: VehicleType.java, v 0.1 2020-05-18 20:00 paras.chawla Exp $$
 */

/*
* The constructor for an enum type must be package-private or private access.
* It automatically creates the constants that are defined at the beginning of the enum body.
* You cannot invoke an enum constructor yourself.
*
* https://stackoverflow.com/questions/3664077/why-cant-enum-constructors-be-protected-or-public-in-java
* */
public enum VehicleType {

    CAR(400),
    TRUCK(1000),
    ELECTRIC(500),
    MOTORBIKE(100);

    private int maxHeight;

    VehicleType(int maxHeight) {
        this.maxHeight = maxHeight;
    }
}