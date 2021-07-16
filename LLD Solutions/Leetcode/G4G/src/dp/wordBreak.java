package dp;

import java.util.HashSet;
import java.util.Set;

public class wordBreak {

    public static void main(String args[]){
        Set<String> dict = new HashSet<String>();
        dict.add("I");
        dict.add("like");
        dict.add("had");
        dict.add("play");
        dict.add("to");
        String s = "Ihadliketoplay";

        boolean res = breakWord(dict,s);
        System.out.println(res);
    }

    public static boolean breakWord(Set<String>dict,String s){
        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    //         int len = s.length();
//         int dp[][]=new int[len][len];

//         for(int i=0;i<len;i++)
//             for(int j=0;j<len;j++)
//                 dp[i][j]=-1;

//         for(int l=1;l<=len;l++){
//             for(int i=0;i<len-l+1;i++){
//                 int j=i+l-1;
//                 String word = s.substring(i,j+1);
//                 if(wordDict.contains(word)){
//                     dp[i][j]=i;
//                     continue;
//                 }


//                 for(int k=i+1;k<=j;k++){
//                     if(dp[i][k-1]!=-1 && dp[k][j]!=-1)
//                     {
//                         dp[i][j]=k;
//                         break;
//                     }
//                 }
//             }
//         }

//         if(dp[0][len-1]==-1)
//             return false;

//         return true;
}
