package SystemDesign.LowLevelCacheDesign.main.java.com.cache.factories;

import SystemDesign.LowLevelCacheDesign.main.java.com.cache.Cache;
import SystemDesign.LowLevelCacheDesign.main.java.com.cache.storage.HashMapBasedStorage;
import SystemDesign.LowLevelCacheDesign.main.java.com.cache.policies.LRUEvictionPolicy;
//import com.uditagarwal.cache.Cache;
//import com.uditagarwal.cache.policies.LRUEvictionPolicy;
//import com.uditagarwal.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(),
                new HashMapBasedStorage<Key, Value>(capacity));
    }
}
