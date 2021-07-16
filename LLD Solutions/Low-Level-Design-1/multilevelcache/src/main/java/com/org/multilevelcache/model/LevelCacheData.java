/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.org.multilevelcache.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author paras.chawla
 * @version $Id: LevelCacheData.java, v 0.1 2020-12-27 3:02 PM paras.chawla Exp $$
 * Every Level has its own readTime and writeTime taken attributes
 */
@Getter
@AllArgsConstructor
public class LevelCacheData {

    // read Time taken to read k-v in this particular Level
    int readTime;

    // write Time taken to write K-V in this particular level
    int writeTime;

}