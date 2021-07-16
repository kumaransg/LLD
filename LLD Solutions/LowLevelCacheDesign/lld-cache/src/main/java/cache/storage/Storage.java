package cache.storage;

import cache.exceptions.NotFoundException;
import cache.exceptions.StorageFullException;

public interface Storage<Key,Value> {

    void add(Key key, Value value) throws StorageFullException;

    void remove(Key key) throws NotFoundException;

    Value get(Key key) throws NotFoundException;

}
