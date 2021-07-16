package LinkedList;

import java.util.Hashtable;

public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node) {
        node.pre=head;
        node.post=head.post;
        head.post.pre=node;
        head.post=node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        pre.post=post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        head.pre=node;
        this.addNode(node);

    }

    // pop the current tail.
    private DLinkedNode popTail(){
        DLinkedNode r = tail.pre;
        this.removeNode(r);
        return r;
    }


    public int get(int key) {
        DLinkedNode n = cache.get(key);
        if(n==null)
            return -1;

        this.moveToHead(n);
        return n.value;
    }


    public void put(int key, int value) {
        DLinkedNode d = cache.get(key);
        if(d==null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.value=value;
            newNode.key=key;
            this.cache.put(key,newNode);
            this.addNode(newNode);
            ++count;
            if(count>capacity){
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        }
        else {
            d.value=value;
            this.moveToHead(d);
        }
    }
    public static void main(String args[]){
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
