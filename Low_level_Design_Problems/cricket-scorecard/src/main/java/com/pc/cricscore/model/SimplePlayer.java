/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.cricscore.model;

import javax.annotation.Nonnull;

/**
 * @author paras.chawla
 * @version $Id: SimplePlayer.java, v 0.1 2020-11-06 23:42 paras.chawla Exp $$
 *
 * A very simple implementation of a player that just holds the player's name.
 *
 */
public class SimplePlayer extends com.danielflower.crickam.scorer.Score implements Player {

    private final String fullName;

    public SimplePlayer(String fullName) {
        this.fullName = fullName;
    }

    @Nonnull
    @Override
    public String name() {
        return null;
    }

    @Override
    public String toString(){
        return fullName;
    }

}