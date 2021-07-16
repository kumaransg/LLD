package com.system.design.ds.graph.dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PlaneReservation {
    public static void main(String[] args) {
        Map<Character,Integer> map = new HashMap<>();
        String[] booked = "1A 2F 1C".split(" ");
        char ch ='A';
        int n = 2;
        boolean[][] seat = new boolean[n][10];
        for( int i =0; i <= 9; i++){
            map.put(ch++,i);
            if( ch == 'I') ch++;
        }
        for( String str : booked ){
            int row = Integer.parseInt(str.charAt(0)+"");
            int col = map.get(str.charAt(1));
            seat[--row][col]= true;
        }
        int result=0;
        for( boolean[] row : seat){
            int current =0;
            boolean flag = true;
            for( int i =1; i <=4; i++ ){
                if( row[i]){
                    flag = false;
                    break;
                }
            }
            if( flag) result++;
            else flag = true;
            for( int i = 5; i <= 8; i++ ){
                if( row[i]) {
                    flag = false;
                    break;
                }
            }
            if( flag) result++;
            else flag = false;
            if(!flag){
                flag = true;
                for( int i = 3; i<=6;i++ ){
                    if( row[i]) {
                        flag = false;
                        break;
                    }
                }
                if( flag) result+=1;
            }
        }
        for(boolean[] test : seat){
            System.out.println(Arrays.toString(test));
        }
        System.out.println("result::"+ result);
    }
}
