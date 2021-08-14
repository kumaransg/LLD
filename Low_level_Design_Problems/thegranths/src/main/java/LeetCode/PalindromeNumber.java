package LeetCode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x <0) return false;
        if(x == reverse(x)) return true;
        return false;
    }

    private int reverse(int y){
        int num=0;
        while(y>0){
            num=num*10+(y%10);
            y=y/10;
        }
        return num;
    }
}
