/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.org.multilevelcache.provider;

import com.org.multilevelcache.model.LevelCacheData;
import com.org.multilevelcache.model.ReadResponse;
import com.org.multilevelcache.model.WriteResponse;
import lombok.AllArgsConstructor;
import org.gojek.cachelib.cache.Cache;

/**
 * @author paras.chawla
 * @version $Id: MultiLevelCache.java, v 0.1 2020-12-27 3:24 PM paras.chawla Exp $$
 */

// Represent Single level of Cache having levelCacheData + CacheProvider
@AllArgsConstructor
public class MultiLevelCache<K, V> implements ILevelCache<K, V> {

    private final LevelCacheData levelCacheData;
    private final Cache<K, V>    cacheProvider;

    private final ILevelCache<K, V> nextLevel;

    // L1 -> L2 -> L3 -> L4
    public ReadResponse<V> get(K key) {
        Double totalTimeTaken = 0.0;

        V curLevelValue = this.cacheProvider.get(key);
        totalTimeTaken += this.levelCacheData.getReadTime();

        if (curLevelValue == null) {
            ReadResponse<V> nextLevelResponse = this.nextLevel.get(key);
            totalTimeTaken += nextLevelResponse.getTotalTimeTaken();
            curLevelValue = nextLevelResponse.getValue();

            // if value at Level n founds to be not null, then we need to Write that particular value in all top levels
            // Also , Add write time in totalTimeTaken
            if (curLevelValue != null) {
                cacheProvider.put(key, curLevelValue);
                totalTimeTaken += levelCacheData.getWriteTime();
            }
        }
        return new ReadResponse<V>(curLevelValue, totalTimeTaken);
    }

    /* L1 -> L2 -> L3 -> L4
    2. WRITE KEY Operation:

    a) Write will start from L1 level.
    b) Write the value of KEY at this level and all the levels below it.
    c) If at any level, value of KEY is same as given VALUE then don't write again and return.
    d) Total Write time is the sum of Write times of all levels where WRITE operation was attempted and Read time of all levels where
    READ operation was attempted.
       You have to print the total TIME taken to write this KEY-VALUE.
    */
    public WriteResponse put(K k, V v) {
        Double totalTimeTaken = 0.0;

        V existingValue = this.cacheProvider.get(k);
        totalTimeTaken += this.levelCacheData.getReadTime();

        if (!existingValue.equals(v)) {
            this.cacheProvider.put(k, v);
            totalTimeTaken += this.levelCacheData.getWriteTime();
        }

        // if curLevelValue is same as that of value to put in cache, don't write and just return
        totalTimeTaken +=this.nextLevel.put(k,v).getTotalTimeTaken();
        return new WriteResponse(totalTimeTaken);
    }
}