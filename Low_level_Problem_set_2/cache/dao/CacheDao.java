package cache.dao;

import cache.policy.IEvictionPolicy;
import cache.storage.IStorage;

import java.io.*;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author priyamvora
 * @created 02/05/2021
 */
public class CacheDao<Key, Value> {
    private final IEvictionPolicy<Key> evictionPolicy;
    TreeMap<String, Integer> treeMap = new TreeMap<>();

    // File backed message queue
    // ops - produce, consume, topic, currentElementsInQueue(),
    // queue.txt -> startPtr - 0(consume pointer), endPtr - 1 (produce pointer)
    // -> key - a, value - b
    // -> key - c, value - d

    // Hbase -> put(rowkey, colfal, col, value), get(rowkey, colfal, col), delete(rowkey, colfal, col),
    // Map<rowkey, Map<Cf, Map<col, value>>>
    // Set<ColFal>
    // put ->
    // Value - content, ts
    // scan
    private final IStorage<Key, Value> storage;

    public CacheDao(IEvictionPolicy<Key> evictionPolicy, IStorage<Key, Value> storage) throws IOException {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
        SortedMap<String, Integer> stringIntegerSortedMap = treeMap.subMap("abv", "abc");
        for (String key : stringIntegerSortedMap.keySet()) {

        }


    }

    public void debug() {
        System.out.println(evictionPolicy);
        System.out.println(storage);
    }


    public void put(Key key, Value value) {
        boolean success = storage.add(key, value);
        if (!success) {
            Key key1 = evictionPolicy.evictKey();
            storage.remove(key1);
            storage.add(key, value);
        }
        evictionPolicy.keyAccessed(key);
    }

    public Value get(Key key) {
        Value value = storage.get(key);
        if (value != null) {
            evictionPolicy.keyAccessed(key);
        }
        return value;
    }

    @Override
    public String toString() {
        return "CacheDao{" +
                "evictionPolicy=" + evictionPolicy +
                ", storage=" + storage +
                '}';
    }
}
