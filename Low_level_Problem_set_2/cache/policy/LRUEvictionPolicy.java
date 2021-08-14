package cache.policy;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author priyamvora
 * @created 02/05/2021
 */
public class LRUEvictionPolicy<Key> implements IEvictionPolicy<Key> {
    private final HashSet<Key> hashSet;
    private final Deque<Key> dll;

    public LRUEvictionPolicy() {
        hashSet = new HashSet<>();
        dll = new LinkedList<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if (hashSet.contains(key)) {
            dll.remove(key);
        }
        hashSet.add(key);
        dll.addFirst(key);
    }

    @Override
    public Key evictKey() {
        Key key = dll.removeLast();
        hashSet.remove(key);
        return key;
    }

    @Override
    public String toString() {
        return "LRUEvictionPolicy{" +
                "hashSet=" + hashSet +
                ", dll=" + dll +
                '}';
    }
}
