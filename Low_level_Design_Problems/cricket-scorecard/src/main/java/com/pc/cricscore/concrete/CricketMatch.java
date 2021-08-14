/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.pc.cricscore.concrete;

import com.pc.cricscore.model.Balls;
import com.pc.cricscore.model.Innings;

/**
 * @author paras.chawla
 * @version $Id: CricketMatch.java, v 0.1 2020-11-07 00:20 paras.chawla Exp $$
 * Game of Cricket between 2 teams
 */
public class CricketMatch {

    public enum State {
        NOT_STARTED, IN_PROGRESS, COMPLETED
    }

    private final State   state;
    private final Innings currentInnings;
    private final Balls   balls;
    private final MatchResult result;



}