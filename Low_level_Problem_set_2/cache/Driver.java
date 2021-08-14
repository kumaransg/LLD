package cache;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author priyamvora
 * @created 02/05/2021
 */
class Value {
    Class clazz;
    Object value;
}

public class Driver {
    public static void main(String[] args) throws IOException {
//        CacheDao<String, String> cacheDao = new CacheDao<String, String>(new LRUEvictionPolicy<String>(), new InMemoryStorage<String, String>(1));
//        CacheDao<String, String> cacheDao2 = new CacheDao<String, String>(new LRUEvictionPolicy<String>(), new InMemoryStorage<String, String>(2));
//        CacheDao<String, String> cacheDao3 = new CacheDao<String, String>(new LRUEvictionPolicy<String>(), new InMemoryStorage<String, String>(3));
//        LevelCacheData level1CacheData = new LevelCacheData(10, 30);
//        LevelCacheData level2CacheData = new LevelCacheData(10, 30);
//        LevelCacheData level3CacheData = new LevelCacheData(10, 30);
//
//        DefaultLevelCache<String, String> l1Cache = new DefaultLevelCache<>(level1CacheData, cacheDao);
//        DefaultLevelCache<String, String> l2Cache = new DefaultLevelCache<>(level2CacheData, cacheDao2);
//        DefaultLevelCache<String, String> l3Cache = new DefaultLevelCache<>(level3CacheData, cacheDao3);
//        l1Cache.setNext(l2Cache);
//        l2Cache.setNext(l3Cache);
//
//        l1Cache.set("1", "abc");
//        l1Cache.debug();
//        System.out.println();
//
//        l1Cache.set("2", "def");
//        l1Cache.debug();
//        System.out.println();
//
//        l1Cache.set("3", "ghi");
//        l1Cache.debug();
//        System.out.println();
//
//        System.out.println(l1Cache.get("2"));
//        l1Cache.debug();
//
//        File file = new File("/Users/priyamvora/MachineCoding/src/cache/tesr.txt");
//        OutputStream outputStream = new FileOutputStream(file);
//        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
//        dataOutputStream.writeInt(4);
//        dataOutputStream.writeBytes("abcd");
        Value value = new Value();
        value.clazz = Integer.class;
        value.value = 123;
        System.out.println(value.clazz.cast(value.value).getClass().getName());

//        dataOutputStream.close();
//        outputStream.close();
//
//        InputStream inputStream = new FileInputStream(file);
//        DataInputStream dataInputStream = new DataInputStream(inputStream);


        //System.out.println(dataInputStream.readLong());
        // int x = dataInputStream.readInt();
//            int i=0;
//            while (i++ < x){
//                System.out.println(dataInputStream.readChar());
//            }
        //  System.out.println(x);
//            byte by[] = new byte[x*2];
//            dataInputStream.read(by);
//            for(byte b: by){
//                System.out.println((char)b);
//            }
//            System.out.println(Arrays.toString(by));
    }

}
