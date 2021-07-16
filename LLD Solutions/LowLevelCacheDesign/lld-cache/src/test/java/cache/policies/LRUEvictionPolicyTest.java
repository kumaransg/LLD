package cache.policies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class LRUEvictionPolicyTest {
    private LRUEvictionPolicy<Integer> lruEvictionPolicy;

    @BeforeEach
    void setUp() {
        lruEvictionPolicy = new LRUEvictionPolicy<>();
    }

    @Test
    void testNoKeyToEvictInitially() {
        assertNull(lruEvictionPolicy.evictKey());
    }

    @Test
    void testKeysAreEvictedInTheOrderInWhichTheyAreAccessedAccess() {
        lruEvictionPolicy.keyAccessed(1);
        lruEvictionPolicy.keyAccessed(2);
        lruEvictionPolicy.keyAccessed(3);
        lruEvictionPolicy.keyAccessed(4);
        assertEquals(1, (Object) lruEvictionPolicy.evictKey());
        assertEquals(2, (Object)lruEvictionPolicy.evictKey());
        assertEquals(3, (Object)lruEvictionPolicy.evictKey());
        assertEquals(4, (Object)lruEvictionPolicy.evictKey());
    }

    @Test
    void testReaccesingKeyPreventsItFromEviction() {
        lruEvictionPolicy.keyAccessed(1);
        lruEvictionPolicy.keyAccessed(2);
        lruEvictionPolicy.keyAccessed(3);
        lruEvictionPolicy.keyAccessed(2);
        lruEvictionPolicy.keyAccessed(4);
        lruEvictionPolicy.keyAccessed(1);
        lruEvictionPolicy.keyAccessed(5);
        assertEquals(3, (Object)lruEvictionPolicy.evictKey());
        assertEquals(2, (Object)lruEvictionPolicy.evictKey());
        assertEquals(4, (Object)lruEvictionPolicy.evictKey());
        assertEquals(1, (Object)lruEvictionPolicy.evictKey());
        assertEquals(5, (Object)lruEvictionPolicy.evictKey());
    }
}