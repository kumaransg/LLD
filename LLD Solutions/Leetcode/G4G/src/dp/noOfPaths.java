package dp;
import java.io.*;
import java.util.*;

public class noOfPaths {

    static int numOfPathsToDest(int n) {
        // your code goes here
        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return memo(n-1,n-1, dp);
    }
    static int memo(int i, int j, int[][]dp){
        if(i<0 || j<0)
            return 0;
        else if(i<j)
            dp[i][j]=0;
        else if(dp[i][j]!=-1)
            return dp[i][j];
        else if(i==0 || j==0)
            dp[i][j]=1;
        else{
            dp[i][j]= memo(i,j-1,dp)+memo(i-1,j,dp);
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        System.out.println(numOfPathsToDest(4));
        List<StringBuilder>[] ls = new List[4];

//        double a = Math.pow(25, 1.0 / n);
//        return Math.abs(a - Math.round(a)) < precision; // if a and round(a) are "cl
    }
}

