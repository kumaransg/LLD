//package SystemDesign.LowLevelCacheDesign.test.java.com.uditagarwal.cache.policies;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class LRUEvictionPolicyTest {
//    private com.uditagarwal.cache.policies.LRUEvictionPolicy<Integer> lruEvictionPolicy;
//
//    @BeforeEach
//    void setUp() {
//        lruEvictionPolicy = new com.uditagarwal.cache.policies.LRUEvictionPolicy<>();
//    }
//
//    @Test
//    void testNoKeyToEvictInitially() {
//        assertNull(lruEvictionPolicy.evictKey());
//    }
//
//    @Test
//    void testKeysAreEvictedInTheOrderInWhichTheyAreAccessedAccess() {
//        lruEvictionPolicy.keyAccessed(1);
//        lruEvictionPolicy.keyAccessed(2);
//        lruEvictionPolicy.keyAccessed(3);
//        lruEvictionPolicy.keyAccessed(4);
//        assertEquals(1, lruEvictionPolicy.evictKey());
//        assertEquals(2, lruEvictionPolicy.evictKey());
//        assertEquals(3, lruEvictionPolicy.evictKey());
//        assertEquals(4, lruEvictionPolicy.evictKey());
//    }
//
//    @Test
//    void testReaccesingKeyPreventsItFromEviction() {
//        lruEvictionPolicy.keyAccessed(1);
//        lruEvictionPolicy.keyAccessed(2);
//        lruEvictionPolicy.keyAccessed(3);
//        lruEvictionPolicy.keyAccessed(2);
//        lruEvictionPolicy.keyAccessed(4);
//        lruEvictionPolicy.keyAccessed(1);
//        lruEvictionPolicy.keyAccessed(5);
//        assertEquals(3, lruEvictionPolicy.evictKey());
//        assertEquals(2, lruEvictionPolicy.evictKey());
//        assertEquals(4, lruEvictionPolicy.evictKey());
//        assertEquals(1, lruEvictionPolicy.evictKey());
//        assertEquals(5, lruEvictionPolicy.evictKey());
//    }
//}