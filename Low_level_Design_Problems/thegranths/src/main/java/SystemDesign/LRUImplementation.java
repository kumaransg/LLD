package SystemDesign;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUImplementation {
    HashSet<Integer>  hSet = new HashSet<>();
    Deque<Integer> q = new LinkedList<>();
    private final int cacheSize=100;
    private void updateCache(int val){
       if(!hSet.contains(val)){
           if(q.size()==cacheSize){
               int last = q.removeLast();
               hSet.remove(last);
           }else{
               q.removeLast();
           }
           q.push(val);
           hSet.add(val);
       }
    }

    private void displayQueue(){
        Iterator<Integer> i =  q.iterator();
        while(i.hasNext()){
            System.out.println("Value is: "+i.next());
        }
    }
}
