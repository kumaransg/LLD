package LeetCode;

public class ReverseString {
    public void reverseString(char[] s) {

        int lo=0,hi=s.length-1;
        while(lo<hi){
            char tmp=s[hi];
            s[hi] = s[lo];
            s[lo] = tmp;
            hi--;
            lo++;
        }

    }
}
