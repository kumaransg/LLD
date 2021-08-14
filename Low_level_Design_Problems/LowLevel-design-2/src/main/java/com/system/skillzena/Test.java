package com.system.skillzena;

import java.util.*;
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        for( int i =0; i < test;i++) {
            String[] str = sc.nextLine().split(" ");
            int n =   Integer.parseInt(str[0]);
            int k =   Integer.parseInt(str[1]);
            int p =   Integer.parseInt(str[2]);

            int[][] arr = new int[n][k];

            for( int j =0; j < n; j++ ) {
                String[] str1 = sc.nextLine().split(" ");
                for( int l =0; l < str1.length; l++ ) {
                    arr[j][l] = Integer.parseInt(str1[l].trim());
                }
            }
            int result = helper(arr, n, k, p);
            System.out.println("Case #"+(i+1) +": "+ result);
        }
    }



    private static int helper(int[][] arr, int n, int k, int p) {
        int[][] preSum =  new int[n][k];
        for( int i =0; i < n; i++ ) {
            preSum[i][0] = arr[i][0];
        }
        for( int i =0; i < n; i++ ) {
            for( int j =1; j < k; j++ ) {
                preSum[i][j] = arr[i][j] + preSum[i][j-1];
            }
        }
        for( int[] a : preSum) {
            System.out.println(Arrays.toString(a));
        }
        // row, col, cost, coumt
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[2] == b[2])
                return a[3] - b[3];
            return a[2] - b[2];
        });

        PriorityQueue<int[]> result = new PriorityQueue<>((a, b) -> {
                return a[3] - b[3];
        });

        for( int i =0; i < preSum.length; i++ ) {
            for( int j =0; j < preSum[0].length; j++ ) {
                pq.add(new int[]{i, j, (int) preSum[i][j], j+1});
            }
        }
        int max = Integer.MIN_VALUE;
        int count = 0;
        int cost = 0;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            cost += temp[2];
            count =+ temp[3];
            result.add(temp);
            if( count > k ) {
                while ( !result.isEmpty() && count > k ) {
                    int[] temp2 = result.poll();
                    cost -= temp2[2];
                    count -= temp2[3];
                }
            }
            if( count == k ) {
                max = Math.max( max, cost);
            }
        }
        return max;
    }
}
