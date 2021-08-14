package dp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class coinChangeMin {
    public static void main(String [] args){
        int[] coins = new int[]{1,2,5};
        int sum=11;
        int res = getCount(coins,sum);
        System.out.println(res);
    }

    public static int getCount(int[] coins, int amount) {

        int n = coins.length;
        int[] dp = new int[amount+1];
        // for(int i=1;i<n;i++)
        //     dp[i]=Integer.MAX_VALUE-1;


        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int j=1;j<=amount;j++){
            for(int i=0;i<n;i++){
                if(j>=coins[i]){
                    //if(dp[j-coins[i]]+1<dp[i]){
                    dp[j]=Math.min(1+dp[j-coins[i]],dp[j]);
                    //}
                }
            }
        }

        return dp[amount]>amount?-1:dp[amount];
    }
}
