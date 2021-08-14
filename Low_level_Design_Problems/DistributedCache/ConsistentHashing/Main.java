package DistributedCache.ConsistentHashing;

public class Main {
    public static void main(String[] args) {

        int numberOfReplicas = 1;
        HashFunction hashFunction = new HashFunction();

        MapClient map = new ConsistentHashRing(numberOfReplicas, hashFunction);


        //add a new server to the mix
        Server newServer1 = new Server("10.0.0.1");
        Server newServer2 = new Server("10.0.0.2");
        Server newServer3 = new Server("10.0.0.3");

        map.addServerToHashRing(newServer1);
        map.addServerToHashRing(newServer2);
        map.addServerToHashRing(newServer3);


        map.put("Nikhil", "Agrawal1");
        Server server = map.getServerForGivenKey("Nikhil");
        System.out.println(server.getIpAddress());


        map.put("Ritu", "Agrawal2");
        server = map.getServerForGivenKey("Ritu");
        System.out.println(server.getIpAddress());


        map.put("Key1blaKey1blaKey1blaKey1blaKey1bla", "Agrawal3");
        server = map.getServerForGivenKey("Ritu");
        System.out.println(server.getIpAddress());

        // deleting server storing the key value pair
        map.removeServerToHashRing(newServer1);

        // accessing key-value pair after stored server is deleted
        server = map.getServerForGivenKey("Nikhil");
        System.out.println(server.getIpAddress());


        Entry entry = map.get("Nikhil");
        System.out.println(entry);

        entry = map.get("Ritu");
        System.out.println(entry);

        entry = map.get("Key1blaKey1blaKey1blaKey1blaKey1bla");
        System.out.println(entry);


    }
}
