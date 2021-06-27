package DistributedCache.ConsistentHashing;

public class HashFunction {

    public Integer createHash(String input) {
        int hash = 7;
        for (int i = 0; i < input.length(); i++) {
            hash = hash * 31 + input.charAt(i);
        }

        return hash;
    }
}
