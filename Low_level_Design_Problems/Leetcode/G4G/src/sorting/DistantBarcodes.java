package sorting;

import java.util.*;

public class DistantBarcodes {
    public static void main(String args[]){
        int[] arr = new int [] {1,1,1,2,2,2};

        arr = rearrangeBarcodes(arr);
        //System.out.println(Arrays.toString(ls.toArray()));
    }

    public static int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        if(barcodes == null || barcodes.length == 0)
            return new int[0];

        for(int a: barcodes)
            hm.put(a,hm.getOrDefault(a,0)+1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
                (a,b)->b.getValue()-a.getValue() == 0?a.getKey() - b.getKey(): b.getValue() - a.getValue());

        for(Map.Entry<Integer,Integer> mentry : hm.entrySet())
            pq.offer(mentry);

        int i=0;
        while(!pq.isEmpty()){
            int k=2;
            List<Map.Entry> ls = new ArrayList<Map.Entry>();
            while(k>0 && !pq.isEmpty()){
                Map.Entry<Integer,Integer> mentry1= pq.poll();
                barcodes[i++]=mentry1.getKey();
                mentry1.setValue(mentry1.getValue()-1);
                ls.add(mentry1);
                k--;
            }
            for(Map.Entry<Integer,Integer> e:ls){
                if(e.getValue()>0)
                    pq.add(e);
            }
            if(pq.isEmpty())
                break;
        }
        return barcodes;
    }
}
