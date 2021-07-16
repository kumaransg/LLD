package Array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class findMaximum {


    /*
     * Complete the 'frequencyOfMaxValue' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY numbers
     *  2. INTEGER_ARRAY q
     */

    public static List<Integer> frequencyOfMaxValue(List<Integer> numbers, List<Integer> q) {
        HashMap<Integer,Integer> counter = new HashMap<>();
        for(int i=0;i<numbers.size();i++){
            counter.put(numbers.get(i),counter.getOrDefault(numbers.get(i), 0)+1);
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b)-> Integer.compare(b[0],a[0]));
        for(int key: counter.keySet()){
            int[] arr = {key,counter.get(key)};
            pq.offer(arr);
        }
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<numbers.size();i++){
            int [] arr = pq.peek();
            if(numbers.get(i)!=arr[0]) {
                ls.add(arr[1]);
            }
            else{
                arr = pq.poll();
                ls.add(arr[1]);
                arr[1]=arr[1]-1;
                pq.offer(arr);
                arr = pq.peek();

            }
        }

        System.out.println(ls);
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<q.size();i++){
            int index = q.get(i)-1;
            int count = ls.get(index);
            res.add(count);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        List<Integer>ls = new ArrayList<>();
        ls.add(5);ls.add(4);ls.add(5);ls.add(3);ls.add(2);
        List<Integer>ls2 = new ArrayList<>();
        ls2.add(1);ls2.add(2);ls2.add(3);ls2.add(4);ls2.add(5);
        ls = frequencyOfMaxValue(ls,ls2);
        System.out.println(ls);
    }
}
