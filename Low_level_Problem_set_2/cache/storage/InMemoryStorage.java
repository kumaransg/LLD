package cache.storage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author priyamvora
 * @created 02/05/2021
 */
public class InMemoryStorage<Key, Value> implements IStorage<Key, Value> {
    private final Map<Key, Value> map;
    private final Integer capacity;

    public InMemoryStorage(Integer capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public boolean add(Key key, Value value) {
        if (isStorageFull()) {
            return false;
        }
        map.put(key, value);
        return true;
    }

    @Override
    public void remove(Key key) {
        map.remove(key);
    }

    @Override
    public Value get(Key key) {
        return map.get(key);
    }

    @Override
    public Boolean isStorageFull() {
        return map.size() == capacity;
    }

    @Override
    public String toString() {
        return "InMemoryStorage{" +
                "map=" + map +
                ", capacity=" + capacity +
                '}';
    }
}
