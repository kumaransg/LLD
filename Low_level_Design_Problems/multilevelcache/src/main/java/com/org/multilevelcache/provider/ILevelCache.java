/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.org.multilevelcache.provider;

import com.org.multilevelcache.model.ReadResponse;
import com.org.multilevelcache.model.WriteResponse;
import lombok.NonNull;

/**
 * @author paras.chawla
 * @version $Id: ILevelCache.java, v 0.1 2020-12-27 3:20 PM paras.chawla Exp $$
 */

// MultiLevelCache implements this interface to impl behavior
public interface ILevelCache<K,V> {

    @NonNull
    ReadResponse<V> get(K key);

    @NonNull
    WriteResponse put(K k, V v);

}