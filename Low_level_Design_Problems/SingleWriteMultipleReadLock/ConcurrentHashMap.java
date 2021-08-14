package SingleWriteMultipleReadLock;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Sample java code showing single write and multiple read lock using ReentrantReadWriteLock lock library of java
public class ConcurrentHashMap {

    private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = reentrantReadWriteLock.readLock();
    private final Lock writeLock = reentrantReadWriteLock.writeLock();
    private HashMap<String, String> hashMap = new HashMap();

    public String get(String key){
        String value = null;

        try{
            readLock.lock();
            value = hashMap.get(key);
        }catch (Exception e){

        }
        finally {
            readLock.unlock();
        }
        return value;
    }


    public void put(String key, String value){

        try{
            writeLock.lock();
            hashMap.put(key,value);
        }catch (Exception e){

        }
        finally {
            writeLock.unlock();
        }
    }
}
