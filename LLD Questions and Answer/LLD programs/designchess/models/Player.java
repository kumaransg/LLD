/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package designchess.models;

/**
 * @author paras.chawla
 * @version $Id: Player.java, v 0.1 2020-09-30 16:43 paras.chawla Exp $$
 */
public class Player {

    public Player(String fullName, boolean whiteSide) {
        this.fullName = fullName;
        this.whiteSide = whiteSide;
    }

    private String  fullName;
    private boolean whiteSide = false;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isWhiteSide() {
        return whiteSide;
    }

    public void setWhiteSide(boolean whiteSide) {
        this.whiteSide = whiteSide;
    }
}