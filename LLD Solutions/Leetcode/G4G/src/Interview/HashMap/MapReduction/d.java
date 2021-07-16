package Interview.HashMap.MapReduction;

import java.io.*;
import java.util.*;

/*
 * Restaurant Data Pipeline
 * ========================
 *
 * 1. Imagine you are working at restaurant reservation booking platform
 *    in their data analytics division.  The team wants to analyze
 *    customer bookings to understand trends.   Extend the Mock MapReduce
 *    Framework to compute the following:
 *    A. Count the number of bookings made for each table size.
 *    B. Count the total number of people in bookings across all table
 *       sizes.
 *
 * NOTES:
 *  - If you need more classes, simply define them inline.
 *  - Sprint Framework and annotations won't work in CoderPad.
 *  - For now, make all your fields public, and don't worry about getters
 *    and setters (to save time).
 *  - An abstract MapReduce class is provided as the basis of your MR
 *    implemention.  Please implement the Map and Reduce functions of the
 *    MapReduceImpl class.
 */

class Solution {
    public static void main(String[] args) {


        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World, Ajay");
        strings.add("Hello,World,and,Welcome, to, CoderPad, Ajay");
        strings.add("Hello,Ajay, pad, is, running, Java, " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }

        MapReduceImpl mr = new MapReduceImpl();

        List<Map.Entry<String, Integer>> mapperOutput = mr.RunMapReduce(strings);

        for(Map.Entry<String,Integer> mentry: mapperOutput){
            //Map.Entry<String,Integer> op = Reduce(mentry.getKey(), mentry.getValue());
            System.out.println(mentry.getKey()+"::"+mentry.getValue());
        }

    }
}


class Pair<K, V> {
    public K key;
    public V value;

    Pair() {
    }

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    void put(K key, V value) {
        this.key = key;
        this.value = value;
    }


}





class MapReduceImpl extends MapReduce<String, String, Integer, Map.Entry<String,Integer>>{

    public List<Map.Entry<String, Integer>> Map(String input) {
        System.out.println("words: " + input);
        String []  words = input.split(",");
        List<Map.Entry<String, Integer>> context = new ArrayList<Map.Entry<String, Integer>>();

        //Context context;

        for(String word: words){
            word = word.trim();
            //context.write(word, 1);
            //Map.Entry<String, Integer> mentry = new Map.Entry<>();
            //mentry.put(word,1);

            Map.Entry<String, Integer> mentry = new HashMap.SimpleEntry<String, Integer>(word,1);

            context.add(mentry);
        }

        return context;
    }

    //Mapper -> Shuffle -> Reduced

    public Map.Entry<String, Integer> Reduce(Map.Entry<String, List<Integer>> entry) {

        int sum =0;
        //Map.Entry<String, Integer> result = new Map.Entry<>();

        //for(List<Integer> mentry : entry.getValue()){
        List<Integer> ls = entry.getValue();

        for(Integer a:ls){
            //1,1,1,1
            sum+=a;
        }
        //}
        Map.Entry<String, Integer> result = new HashMap.SimpleEntry<String, Integer>(entry.getKey(),sum);
        //Hello -> 2
        // Hello -> 2, World-2
        return result;
    }
}


abstract class MapReduce<I, K, V, O> {

    public abstract List<Map.Entry<K, V>> Map(I input);

    public abstract O Reduce(Map.Entry<K, List<V>> entry);

    public Map<K, List<V>> Shuffle(List<Map.Entry<K, V>> mapOutList) {
        Map<K, List<V>> reduceInMap = new HashMap<K, List<V>>();
        for (Map.Entry<K, V> output : mapOutList) {
            List<V> valList;
            if (reduceInMap.containsKey(output.getKey())) {
                valList = reduceInMap.get(output.getKey());
            } else {
                valList = new ArrayList<V>();
                reduceInMap.put(output.getKey(), valList);
            }
            valList.add(output.getValue());
        }
        return reduceInMap;
    }

    public List<O> RunMapReduce(List<I> mapInList) {
        List<Map.Entry<K, V>> mapOutList = new ArrayList<Map.Entry<K, V>>();
        System.out.println(mapInList.size());
        for (I input : mapInList) {
            System.out.println("input: " + input + "   mapOutList: " + mapOutList);
            // Fix code: protect against null result from map
            mapOutList.addAll(Map(input));
        }

        Map<K, List<V>> reduceInMap = Shuffle(mapOutList);

        List<O> reduceOutList = new ArrayList<O>();
        for (Map.Entry<K, List<V>> input : reduceInMap.entrySet()) {
            reduceOutList.add(Reduce(input));
        }
        return reduceOutList;
    }
}
