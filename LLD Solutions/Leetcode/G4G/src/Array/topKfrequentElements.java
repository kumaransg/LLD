package Array;

import java.util.*;

public class topKfrequentElements {
    public static void main(String args[]){
        String[] words = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;

        HashMap<String, Integer> hm = new HashMap<>();
        for(String word: words){
            hm.put(word, hm.getOrDefault(word,0)+1);
        }

        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(
                (a,b)-> a.getValue()==b.getValue()?b.getKey().compareTo(a.getKey()):a.getValue()-b.getValue());

        for(Map.Entry<String,Integer>mentry : hm.entrySet()){
            pq.offer(mentry);
            if(pq.size()>k)
                pq.poll();
        }
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(3);
        int a = ts.last();
        ts.pollLast();
        System.out.println(a);
//        while(!pq.isEmpty()){
//            System.out.println(pq.poll().getKey());
//
//            List<Integer> ls = new ArrayList<>();
//            ls.add(2);
//
//        }


    }
}
