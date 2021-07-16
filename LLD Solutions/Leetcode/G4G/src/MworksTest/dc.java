//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.regex.*;
//
//class Result {
//
//    /*
//     * Complete the 'canConstructPalindrome' function below.
//     *
//     * The function is expected to return a STRING.
//     * The function accepts following parameters:
//     *  1. STRING s
//     *  2. INTEGER m
//     */
//
//    public static String canConstructPalindrome(String s, int m) {
//        // The Function should return either "Yes" or "No" as strings.
//        char[] arr = s.toCharArray();
//        //HashMap<Character,Integer>hm = new HashMap<Character,Integer>();
//        HashMap<Character,Integer> hm = new HashMap<>();
//        for(char a: arr){
//            //hm.put(a,hm.getOrDefault(a,0)+1);
//            hm.putIfAbsent(a,0);
//            int val = hm.get(a);
//            hm.put(a,val+1);
//
//        }
//
//        //HashSet<Integer> hs = new HashSet<>();
//        int singleSets =0;
//        int x = m;
//        for(Map.Entry<Character,Integer> mentry: hm.entrySet()){
//            if(mentry.getValue()%2==0){
//                x-=mentry.getValue();
//            }
//            else if((mentry.getValue()-1)%2==0){
//                x-=mentry.getValue()-1;
//            }
//            else
//                singleSets++;
//        }
//
//        if(x<=0) return "Yes";
//        else if(x==1 && singleSets==1)
//            return "Yes";
//        return "No";
//    }
//
//}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//        for (int tItr = 0; tItr < t; tItr++) {
//            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//            int n = Integer.parseInt(firstMultipleInput[0]);
//
//            int m = Integer.parseInt(firstMultipleInput[1]);
//
//            String s = bufferedReader.readLine();
//
//            String ans = Result.canConstructPalindrome(s, m);
//
//            bufferedWriter.write(ans);
//            bufferedWriter.newLine();
//        }
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
