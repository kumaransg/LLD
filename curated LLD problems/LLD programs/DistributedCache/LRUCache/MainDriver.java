package DistributedCache.LRUCache;


/*Implement_LRU_Cache
A cache is a mechanism by which future requests for that data are served faster
and/or at a lower cost.
Requirements
1. Fixed size: The cache needs to have some bounds to limit memory usage.
2. Fast access: O(1) cache insert and lookup operations.
3. Entry replacement algorithm: When the cache is full, the less useful cache
entries are purged from cache. The algorithm to
replace these entries is Least Recently Used (LRU)
or the cache entries which have not been accessed recently will be replaced.
 */

public class MainDriver {

    public static void main(String[] args) {
        // Test case 1.
        LRUCache lrucache = new LRUCache(2);

        print(lrucache.get(1) == -1);

        lrucache.set(2, 1);
        lrucache.printDLL();
        lrucache.set(1, 1);
        lrucache.printDLL();
//        print(lrucache);
        print(lrucache.get(2) == 1);
        lrucache.printDLL();
//        print(lrucache);

        lrucache.set(4, 1);
        lrucache.printDLL();
        print(lrucache.get(1) == -1);
        print(lrucache.get(2) == 1);
        lrucache.printDLL();
    }

    public static void print(Object obj) {
        System.out.println("print :: " + obj);
    }
}
