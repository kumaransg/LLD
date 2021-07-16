package String;

import java.util.Stack;

public class DecodeString {
    public static void main(String args[]){
        String s = "3[a2[c]]";
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        System.out.println(res);
//        while(i<check.length()){
//            int first = check.indexOf('[',i);
//            int second = check.indexOf(']',i);
//            int num = Character.getNumericValue(check.charAt(first-1));
//            String word = check.substring(first+1,second);
//            while(num>0){
//                sb.append(word);
//                num--;
//            }
//            i=second+1;
//        }
       // System.out.println(sb.toString());
    }
}
