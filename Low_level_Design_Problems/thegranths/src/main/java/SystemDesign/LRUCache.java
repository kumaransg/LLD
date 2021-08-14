package SystemDesign;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {

    int size =0;
    Map<Integer,Integer> m = new HashMap<>();
    Deque<Integer> q = new LinkedList<>();
    public LRUCache(int capacity) {
        size = capacity;
    }

    public int get(int key) {
        if(!m.containsKey(key)) return -1;
        q.remove(key);
        q.push(key);
        return m.get(key);

    }

    public void put(int key, int value) {
        if(q.size()==size){
            int val = q.removeLast();
            m.remove(val);
        }else q.remove(key);

        q.push(key);
        m.put(key,value);

    }

    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
        System.out.println(l.get(2));
        l.put(2,6);
        System.out.println(l.get(1));
        l.put(1,5);
        l.put(1,2);
        System.out.println(l.get(1));
        System.out.println(l.get(2));
    }
}