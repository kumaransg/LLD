package DistributedCache.ConsistentHashing;

import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashRing implements MapClient {

    private final SortedMap<Integer, Server> hashRing;
    private int numberOfReplicas;
    private HashFunction hashFunction;


    public ConsistentHashRing(int numberOfReplicas, HashFunction hashFun) {
        this.hashRing = new TreeMap<>();
        this.numberOfReplicas = numberOfReplicas;
        this.hashFunction = hashFun;
    }

    public boolean addServerToHashRing(Server server) {

        for (int i = 0; i < numberOfReplicas; i++) {

            //get hashkey from server ip with the replica number
            String hashKey = server.getIpAddress() + ":" + i;

            //pass hashkey to hashFunction to extract hashedValue
            Integer hashedValue = hashFunction.createHash(hashKey);

            //Insert the server at the hashkey in the Sorted Dictionary
            this.hashRing.put(hashedValue, server);

        }
        return true;
    }

    public boolean removeServerToHashRing(Server server) {

        for (int i = 0; i < numberOfReplicas; i++) {

            //get hashkey from server ip with the replica number
            String hashKey = server.getIpAddress() + ":" + i;

            //pass hashkey to hashFunction to extract hashedValue
            Integer hashedValue = hashFunction.createHash(hashKey);

            // Reindex stores value to next server
            Server serverToBeDeleted = hashRing.get(hashedValue);

            //remove the server at the hashkey in the Sorted Dictionary
            this.hashRing.remove(hashedValue);

            // Reindex Key value pairs of server to be deleted
            for (Entry<String, String> entry : serverToBeDeleted.getEntries()) {
                put(entry.getKey(), entry.getValue());
            }
        }
        return true;
    }

    // get physical server ip from given key
    public Server getServerForGivenKey(String key) {

        if (hashRing.isEmpty())
            return null;

        Integer hash = hashFunction.createHash(key);


        if (hashRing.containsKey(hash)) {
            return hashRing.get(hash);
        } else {

            Server resultServer = null;
            // find first server on hashRing with hash > key
            for (Integer k : hashRing.keySet()) {

                if (k > hash) {
                    resultServer = hashRing.get(k);
                    break;
                }
            }

            // if no server hashkey is greater than incoming key, then choose smallest server hashkey
            if (resultServer == null) {
                Integer serverWithMinHashKey = hashRing.keySet().stream().min(Integer::compare).get();
                resultServer = hashRing.get(serverWithMinHashKey);
            }

            return resultServer;
        }
    }

    @Override
    public Boolean put(String k, String v) {

        // No Server is present on hashRing
        Server serverForGivenKey = getServerForGivenKey(k);

        if (serverForGivenKey == null) {
            return Boolean.FALSE;
        }

        serverForGivenKey.addEntry(new Entry<>(k, v));
        return true;
    }

    @Override
    public Entry get(String k) {

        // No Server is present on hashRing
        Server serverForGivenKey = getServerForGivenKey(k);

        if (serverForGivenKey == null) {
            return null;
        }

        return serverForGivenKey.findEntryForGivenKey(k);

    }
}
