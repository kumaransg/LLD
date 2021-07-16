package DistributedCache.ConsistentHashing;

public interface MapClient {

    public boolean addServerToHashRing(Server server);

    public boolean removeServerToHashRing(Server server);

    public Server getServerForGivenKey(String key);

    public Boolean put(String k, String v);

    public Entry get(String k);

}
