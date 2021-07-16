package cache.policies;

import cache.exceptions.InvalidElementException;

public interface EvictionPolicy<Key> {

    void keyAccessed(Key key) throws InvalidElementException;

    /**
     * Evict key from eviction policy and return it.
     */
    Key evictKey();
}
