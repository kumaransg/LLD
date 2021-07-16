package SystemDesign.LowLevelCacheDesign.main.java.com.cache.storage;

//import com.uditagarwal.cache.exceptions.NotFoundException;
//import com.uditagarwal.cache.exceptions.StorageFullException;

import SystemDesign.LowLevelCacheDesign.main.java.com.cache.exceptions.NotFoundException;
import SystemDesign.LowLevelCacheDesign.main.java.com.cache.exceptions.StorageFullException;

public interface Storage<Key, Value> {
    public void add(Key key, Value value) throws StorageFullException;

    void remove(Key key) throws NotFoundException;

    Value get(Key key) throws NotFoundException;
}
