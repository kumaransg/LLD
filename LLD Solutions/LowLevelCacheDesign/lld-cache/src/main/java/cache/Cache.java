package cache;

import cache.exceptions.NotFoundException;
import cache.exceptions.StorageFullException;
import cache.policies.EvictionPolicy;
import cache.storage.Storage;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class Cache<Key,Value> {

    private final Storage<Key,Value> storage;
    private final EvictionPolicy<Key> evictionPolicy;

    public Cache(Storage storage, EvictionPolicy evictionPolicy){
      this.storage = storage;
      this.evictionPolicy = evictionPolicy;
    }

    public void put(Key key,Value value) throws NotFoundException {

        try{
            storage.add(key,value);
            evictionPolicy.keyAccessed(key);
        }catch(StorageFullException ex){
            Key keytoremove = evictionPolicy.evictKey();
            storage.remove(keytoremove);
            put(key,value);
            ex.printStackTrace();
        }

    }

    public Value get(Key key) throws NotFoundException {

        try{
          Value value = storage.get(key);
          this.evictionPolicy.keyAccessed(key);
          return  value;
        }catch(NotFoundException e){
           e.printStackTrace();
           return null;
        }

    }

}
