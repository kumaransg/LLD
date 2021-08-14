package MworksTest;


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



class travelIsFun {

    /*
     * Complete the 'connectedCities' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER g
     *  3. INTEGER_ARRAY originCities
     *  4. INTEGER_ARRAY destinationCities
     */
    static HashMap<Integer,List<Integer>> hm = new HashMap<>();

    public static List<Integer> connectedCities(int n, int g, List<Integer> originCities, List<Integer> destinationCities) {
        putValue(originCities);
        putValue(destinationCities);
        gcd(originCities);
        gcd(destinationCities);


        List<Integer> ls4 = new ArrayList<>();
        //removing the city
        for(Map.Entry<Integer,List<Integer>> mentry: hm.entrySet()){
            int c = mentry.getKey();
            List<Integer> ls = hm.get(c);
            Collections.sort(ls);
            int sz = ls.size();
            if(ls.get(sz-1)<=g){
//                hm.remove(c);
                ls4.add(c);
            }
        }
        for(int a: ls4)
            hm.remove(a);


        List<Integer> ls3 = new ArrayList<>();

        for(int i=0;i<originCities.size();i++){
            List<Integer> ls1 = hm.get(originCities.get(i));
            List<Integer> ls2 = hm.get(destinationCities.get(i));
            if(ls1!=null && ls2!=null){
                ls1.retainAll(ls2);
            }
            if(ls1!=null && ls1.size()>0){
                ls3.add(1);
            }
            else
                ls3.add(0);

        }
        return ls3;

    }

    public static void putValue(List<Integer> cities){
        for(int city: cities)
            hm.putIfAbsent(city, new ArrayList<Integer>());
    }
    public static void gcd(List<Integer> cities){
        for(int c: hm.keySet()){
            for(int city: cities){
                if(c%city==0){
                    hm.get(c).add(city);
                }
            }
        }
    }

    public static void main(String args[]){

        List<Integer> o = new ArrayList<>();
        o.add(1);
        o.add(2);
        o.add(3);
        List<Integer> d = new ArrayList<>();
        d.add(4);
        d.add(5);
        d.add(6);
        List<Integer> ls = connectedCities(6,2,o,d);

        System.out.println(ls);
    }

}