package DistributedCache.LRUCache;

public class LRUNode {

    public LRUNode left;
    public LRUNode right;
    public int key;
    public int value;

    public LRUNode(int key, int value) {
        this.left = null;
        this.right = null;
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "<" + this.key + ", " + this.value + ">";
    }
}
