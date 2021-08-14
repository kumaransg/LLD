package dp;
import java.io.*;
import java.util.*;

public class editDistanceWithOP {

    static String[] diffBetweenTwoStrings(String source, String target) {

        /*
            For example, with strings source = "ABCDEFG", and target = "ABDFFGH"
            we might return: ["A", "B", "-C", "D", "-E", "F", "+F", "G", "+H"
         */
        int sourceLen = source.length(), targetLen = target.length();

        int[][] dp = new int[sourceLen+1][targetLen+1];
        for(int i=0;i<=sourceLen;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<=targetLen;i++){
            dp[0][i]=i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=sourceLen;i++){
            for(int j=1;j<=targetLen;j++){
                if(source.charAt(i-1)==target.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]= 1+ Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        for(int i=0;i<=sourceLen;i++){
            for(int j=0;j<=targetLen;j++){
                System.out.print(dp[i][j]+"   ");
            }
            System.out.println();
        }


        int i=0, j =0;
        while(i<source.length() && j<target.length()){
            if(source.charAt(i)==target.charAt(j))
            {
                sb.append(source.charAt(i));
                i++;
                j++;
            }
            else{
                if(dp[i+1][j-1]>dp[i][j]){
                    sb.append("-");
                    sb.append(source.charAt(i));
                    i++;
                }
                else{
                    sb.append("+");
                    sb.append(target.charAt(j));
                    j++;
                }
            }
        }
        while(j<target.length())
        {
            sb.append("+");
            sb.append(target.charAt(j++));
        }

        System.out.println(sb.toString());
        return new String[0];

    }

    public static void main(String[] args) {
        String source = "ABCDEFG", target = "ABDFFGH";
        String[] res = diffBetweenTwoStrings(source, target);

        HashSet<Integer> counter = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        int[] arr = {1,2,3,4,2,1};
        for(int num : arr){
            if(counter.contains(num))
                result.add(num);
            counter.add(num);
        }
        System.out.println(result);
    }
}

