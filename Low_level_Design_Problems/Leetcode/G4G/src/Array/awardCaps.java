package Array;
import java.io.*;
import java.util.*;

public class awardCaps {

    static double findGrantsCap(double[] grantsArray, double newBudget) {
        // your code goes here
        int len = grantsArray.length-1;
        double maxCaps=Double.MIN_VALUE;

        for(int i=0;i<grantsArray.length;i++){
            double caps = grantsArray[i];
            while(caps*(len-i+1)>newBudget){
                caps--;
            }
            maxCaps=Math.max(caps,maxCaps);
            newBudget-=caps;
        }

        return maxCaps;
    }

    public static void main(String[] args) {
        double[] grantsArray = {2, 100, 50, 120, 1000};
        int newBudget = 190;

        System.out.println(findGrantsCap(grantsArray,newBudget));

    }

}