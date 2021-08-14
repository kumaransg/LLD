package Array.Solution;

import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Solution obj = new Solution();

        /* You can test using your own custom input */
        String exp = "(]";

        System.out.println(obj.isBalanced(exp));  /*Expected: true*/
    }

    public static boolean isBalanced(String s) {

        
        //TODO: Implement me
        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();
        for (char a : arr) {
            if (a == '(' || a == '{' || a == '[')
                st.push(a);
            else if (!st.isEmpty()) {
                if (a == ')' && st.peek() == '(') {
                    st.pop();
                    continue;
                } else if (a == ']' && st.peek() == '[') {
                    st.pop();
                    continue;
                } else if (a == '}' && st.peek() == '{') {
                    st.pop();
                    continue;
                } else
                    return false;
            } else
                return false;
        }
        if (!st.isEmpty())
            return false;
        return true;

    }

}
