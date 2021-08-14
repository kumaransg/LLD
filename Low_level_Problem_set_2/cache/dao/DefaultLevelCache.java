package cache.dao;

import cache.model.LevelCacheData;
import cache.model.ReadResponse;

/**
 * @author priyamvora
 * @created 03/05/2021
 */
public class DefaultLevelCache<Key, Value> {
    private final LevelCacheData levelCacheData;
    private final CacheDao<Key, Value> cache;

    private DefaultLevelCache<Key, Value> next;

    public DefaultLevelCache(LevelCacheData levelCacheData, CacheDao<Key, Value> cache) {
        this.levelCacheData = levelCacheData;
        this.cache = cache;
    }

    public void setNext(DefaultLevelCache<Key, Value> next) {
        this.next = next;
    }

    public void debug() {
        System.out.println(cache);
        if (next != null) {
            next.debug();
        }
    }
// L1(read time, write time) -> L2 -> L3
    public Integer set(Key key, Value value) {
        Integer currTime = 0;
        Value currentValue = cache.get(key);
        currTime += levelCacheData.getReadTime();
        if (currentValue == null || !currentValue.equals(value)) {
            cache.put(key, value);
            currTime += levelCacheData.getWriteTime();
        }
        if (next != null) {
            currTime += next.set(key, value);
        }
        return currTime;
    }

    public ReadResponse<Value> get(Key key) {
        Integer currTime = 0;
        Value currentValue = cache.get(key);
        currTime += levelCacheData.getReadTime();
        if (currentValue == null) {
            ReadResponse<Value> readResponse = next.get(key);
            currTime += readResponse.getTimeTaken();
            currentValue = readResponse.getValue();
            if (currentValue != null) {
                cache.put(key, currentValue);
                currTime += levelCacheData.getWriteTime();
            }
        }
        return new ReadResponse<>(currentValue, currTime);
    }
}
