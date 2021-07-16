/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.cricscore.concrete;

import com.pc.cricscore.model.LineUp;

/**
 * @author paras.chawla
 * @version $Id: MatchResult.java, v 0.1 2020-11-07 00:33 paras.chawla Exp $$
 */
public class MatchResult {

    /**
     * Describes how a match was won, drawn, tied or otherwise concluded
     */
    public enum ResultType {WON, TIED, DRAWN, NO_RESULT, ABANDONED, AWARDED, CONCEDED}

    private final ResultType resultType;
    private final LineUp     winningTeam;
    private final Integer    wonByAmount;


}