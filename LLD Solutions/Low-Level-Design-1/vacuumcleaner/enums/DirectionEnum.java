/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package vacuumcleaner.enums;

/**
 * @author paraschawla
 * @version $Id: DirectionEnum.java, v 0.1 2020-08-12 8:05 PM paraschawla Exp $$
 */
public enum DirectionEnum {

    N("North"),
    S("South"),
    W("West"),
    E("East"),
    ;

    /**
     * key
     */
    private final String code;

    /**
     * @param code key
     */
    DirectionEnum(String code) {
        this.code = code;
    }

    /**
     * Getter method for property code.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

}