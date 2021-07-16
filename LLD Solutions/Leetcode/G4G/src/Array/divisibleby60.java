package Array;

import java.util.HashMap;
import java.util.Map;

public class divisibleby60 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            int d = (60 - t % 60) % 60  ;
            ans += count.getOrDefault(d, 0); // in current HashMap, get the number of songs that if adding t equals to a multiple of 60.
            count.put(t % 60, 1 + count.getOrDefault(t % 60, 0)); // update the number of t % 60.
        }
        return ans;
    }

    public static void main(String args[]){
        divisibleby60 d = new divisibleby60();
        int [] arr = {60,60,60};//{30,20,150,100,40};
        int a = d.numPairsDivisibleBy60(arr);
        System.out.println(a);
    }

}
