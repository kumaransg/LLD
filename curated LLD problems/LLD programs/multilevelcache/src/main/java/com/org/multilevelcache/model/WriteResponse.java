/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.org.multilevelcache.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author paras.chawla
 * @version $Id: WriteResponse.java, v 0.1 2020-12-27 3:06 PM paras.chawla Exp $$
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WriteResponse<K,V>{
    Double totalTimeTaken;
}