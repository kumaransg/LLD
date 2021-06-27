package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayToFibonnaci {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<>();
        helper(S,result,0);
        return result;
    }

    private boolean helper(String s, List<Integer> result,int pos){
        if(pos == s.length()) {
            return result.size() > 2;
        }

        int num=0;
        int n = s.length();
        for(int i=pos;i<n;i++){
            num= (num*10) + (s.charAt(i)-'0');
            if(num<0) return false;
            if(result.size()<2 || (result.get(result.size()-1) + result.get(result.size()-2))==num){
                result.add(num);
                if(helper(s,result,i+1)) return true;
                result.remove(result.size()-1);
            }
            if(i==pos && s.charAt(i)=='0') return false;
        }
        return false;
    }
}
