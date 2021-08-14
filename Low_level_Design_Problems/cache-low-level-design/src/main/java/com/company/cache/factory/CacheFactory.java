package com.company.cache.factory;

import com.company.cache.Cache;
import com.company.cache.policies.LRUEvictionPolicy;
import com.company.cache.storage.HashMapBasedStorage;

public class CacheFactory<K, V> {
	public Cache<K, V> defaultCache(final int capacity) {
		return new Cache<K, V>(new HashMapBasedStorage<K, V>(capacity), new LRUEvictionPolicy<K>());
	}
}
