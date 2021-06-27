/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.cricscore.model;

import javax.annotation.Nonnull;

/**
 * @author paras.chawla
 * @version $Id: Player.java, v 0.1 2020-11-06 23:17 paras.chawla Exp $$
 * A Cricket Player
 * For simple implementation, you can use @link SimplePlayer
 */
public interface Player {

    /**
     * @return The full (informal) name of the player, such as "Virat Kohli"
     */
    @Nonnull String name();

    /**
     * @return The name of the player to use on the scorecard, e.g. "V Kohli"
     */
    default @Nonnull String scorecardName() {
        String[] tokens = name().split(" ");
        if (tokens.length == 0 || tokens[0].length() < 1) return name();
        return tokens[0].charAt(0) + " " + tokens[tokens.length - 1];
    }

}