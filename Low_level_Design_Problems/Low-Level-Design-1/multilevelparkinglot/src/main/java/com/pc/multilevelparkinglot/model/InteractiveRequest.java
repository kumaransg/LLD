/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.multilevelparkinglot.model;


/**
 * @author paras.chawla
 * @version $Id: InteractiveRequest.java, v 0.1 2020-11-13 09:46 paras.chawla Exp $$
 */
public class InteractiveRequest implements Request {

    private String inputString = null;

    public InteractiveRequest(String inputString) {
        this.inputString = inputString;
    }

    /**
     * @return the inputString
     */
    public String getInputString() {
        return inputString != null ? inputString.trim() : null;
    }

    /**
     * @param inputString the inputString to set
     */
    public void setInputString(String inputString) {
        this.inputString = inputString;
    }
}