package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class kClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        HashMap<int[],Integer> hm = new HashMap<>();
        for(int i =0;i< points.length;i++){
            int dist = (points[i][1]*points[i][1]) + (points[i][0]*points[i][0]);
            System.out.println(dist);
            hm.put(points[i],dist);
        }
        PriorityQueue<Map.Entry<int[],Integer>> pq = new PriorityQueue<>((m1, m2)->m1.getValue()-m2.getValue());

        for(Map.Entry<int[],Integer> mentry: hm.entrySet()){
            pq.add(mentry);
        }

        int[][] res = new int[K][2];
        int index=0;
        for(Map.Entry<int[],Integer>mentry: pq){
            //System.out.println(mentry.getKey());
            int[] r = mentry.getKey();
            //System.out.println(Arrays.toString(r));
            //System.out.println(index);
            res[index][0]=r[0];
            res[index][1]=r[1];
            index++;
            if(index==K)
                break;
        }
        return res;
    }

    public static void main(String args[]){
        kClosestPointstoOrigin k = new kClosestPointstoOrigin();
        int [][] res ={{3,3},{5,-1},{-2,4}};
        res =  k.kClosest(res,2);
        System.out.println(Arrays.deepToString(res));
    }

}
