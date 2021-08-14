/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.org.multilevelcache.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author paras.chawla
 * @version $Id: ReadResponse.java, v 0.1 2020-12-27 3:05 PM paras.chawla Exp $$ Value return along with total Time taken(Read time and
 * write Time)
 */

@Getter
@AllArgsConstructor
@ToString
public class ReadResponse<V> {
    V value;
    Double totalTimeTaken;
}