package cache.policies;

import algorithms.DoublyLinkedList;
import algorithms.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{

    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy(){
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {

     if(mapper.containsKey(key)){

         dll.detachNode(mapper.get(key));
         dll.addElementAtLast(key);
     }else{
         DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
         mapper.put(key, newNode);
     }

    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> node = dll.getLastNode();

        if(node!= null){
            dll.detachNode(node);
            return node.getElement();
        }
        return null;
    }
}
