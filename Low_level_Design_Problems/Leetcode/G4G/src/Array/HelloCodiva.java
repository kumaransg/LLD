package Array;

//package com.example;
import java.lang.reflect.Array;
import java.util.*;

class HelloCodiva {
    public static void main(String[] args) {
        HelloCodiva obj = new HelloCodiva();
        /* You can test using your own custom input */
        int[][] intervals = {{0,30},{5,10},{15,20}};
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        System.out.println(obj.canAttendMeetings(intervals));  /*Expected: false*/
    }



    public boolean canAttendMeetings(int[][] intervals) {

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i-1][1]>intervals[i][0])
                return false;
        }
        return true;
    }

}