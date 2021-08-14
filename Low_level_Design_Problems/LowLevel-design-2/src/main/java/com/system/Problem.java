package com.system;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        for( int i =0; i < testCases; i++ ) {
            int size = Integer.parseInt(sc.nextLine());
            int[][] matrix = new int[size][size];

            for( int j=0;  j < size; j++ ) {
                String[] strArr = sc.nextLine().split(" ");
                for( int k=0; k < strArr.length;k++ ) {
                    matrix[i][k] = Integer.parseInt(strArr[k]);
                }
            }

            int row =0;
            int col =0;
            int sum =0;
            for( int k =0; k < size; k++ ) {
                sum += matrix[k][k];
            }
            for( int k=0; k < size; k++ ) {
                // for each row
                Set<Integer> set = new HashSet<>();
                for( int l =0; l < size; l++ ) {
                    if( set.contains( matrix[k][l])) {
                        row++;
                        break;
                    }
                    set.add(matrix[k][l]);
                }
                set.clear();
                // for each col
                for( int l =0; l < size; l++ ) {
                    if( set.contains( matrix[l][k])) {
                        col++;
                        break;
                    }
                    set.add(matrix[l][k]);
                }
            }
            System.out.println("Case #" + i+1 + ":"+ sum + " "+ row + " "+ col);
        }
    }
}
