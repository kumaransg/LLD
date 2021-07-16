package Array;

import java.util.PriorityQueue;
import java.util.Queue;

public class PathmaxMinValue {

    public int maximumMinimumPath(int[][] A) {
        final int[][] DIRS = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        pq.add(new int[] {A[0][0], 0, 0});
        int maxscore = A[0][0];
        A[0][0] = -1; // visited
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int i = top[1], j = top[2], n = A.length, m = A[0].length;
            maxscore = Math.min(maxscore, top[0]);
            if(i == n - 1 && j == m - 1)
                break;
            for(int[] d : DIRS) {
                int newi = d[0] + i, newj = d[1] + j;
                if(newi >= 0 && newi < n && newj >= 0 && newj < m && A[newi][newj]>=0){
                    pq.add(new int[] {A[newi][newj], newi, newj});
                    A[newi][newj] = -1;
                }
            }
        }
        return maxscore;
    }
    public static void main(String args[]){
        PathmaxMinValue p = new PathmaxMinValue();
        int [][] path = {{5,4,5},{1,2,6},{7,4,6}};
        int res = p.maximumMinimumPath(path);
        System.out.println(res);
    }
}


