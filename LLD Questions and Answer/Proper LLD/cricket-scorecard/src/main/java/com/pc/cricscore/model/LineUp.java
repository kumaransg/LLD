/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.cricscore.model;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author paras.chawla
 * @version $Id: LineUp.java, v 0.1 2020-11-07 00:35 paras.chawla Exp $$
 * A team line up
 */
public interface LineUp<T extends Player> {

    /**
     * @return The playing team, in their beginning batting order
     */
    @Nonnull
    ImmutableList<T> battingOrder();

    /**
     * @return The captain of the team, if known
     */
    @Nullable
    T captain();

    /**
     * @return The primary wicket-keeper in this line up, if known
     */
    @Nullable
    T wicketKeeper();

    /**
     * @return The name of the team
     */
    @Nonnull
    String teamName();
}