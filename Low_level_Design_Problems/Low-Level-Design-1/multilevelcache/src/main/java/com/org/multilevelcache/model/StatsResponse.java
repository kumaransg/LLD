/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.org.multilevelcache.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * @author paras.chawla
 * @version $Id: StatsResponse.java, v 0.1 2020-12-27 3:09 PM paras.chawla Exp $$
 * Gives Avg Read and Write Time
 */
@Getter
@AllArgsConstructor
public class StatsResponse {

    private final Double       avgReadTime;
    private final Double       avgWriteTime;
    private final List<Double> usages;
}