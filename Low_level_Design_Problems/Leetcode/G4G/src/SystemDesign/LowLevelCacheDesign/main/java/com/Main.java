package SystemDesign.LowLevelCacheDesign.main.java.com;

import SystemDesign.LowLevelCacheDesign.main.java.com.cache.Cache;
import SystemDesign.LowLevelCacheDesign.main.java.com.cache.factories.CacheFactory;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CacheFactory cf = new CacheFactory();
        Cache c = cf.defaultCache(10);
        c.put(1,1);

    }
}
