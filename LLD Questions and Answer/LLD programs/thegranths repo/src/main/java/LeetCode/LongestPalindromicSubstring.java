package LeetCode;

public class LongestPalindromicSubstring {
    int startPoint=0, maxLength=0;
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            getPalindome(s,i,i);
            getPalindome(s,i,i+1);
        }

        return s.substring(startPoint,startPoint+maxLength);
    }

    private void getPalindome(String s,int left, int right){
        while(left >=0 && right <s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        if(maxLength < right-left-1){
            maxLength = right-left-1;
            startPoint = left+1;
        }

    }
}
