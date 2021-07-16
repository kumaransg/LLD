package String;

import java.util.TreeSet;

public class LastSubstringinLexoOrder {

    public String lastSubstring(String s) {
        TreeSet<Character> ts = new TreeSet<>();
        for (int i = 0; i < s.length(); ++i)
            ts.add(s.charAt(i));
        int radix = ts.size(), lo = 0;
        double max = 0d, cur = 0d;
        for (int i = s.length() - 1; i >= 0; --i) {
            cur = ts.headSet(s.charAt(i)).size() + cur / radix;
            if (max <= cur) {
                max = cur;
                lo = i;
            }
        }
        return s.substring(lo);
    }

    public static void main(String args[]){
        LastSubstringinLexoOrder ls = new LastSubstringinLexoOrder();
        String check = "abab";
        check = ls.lastSubstring(check);
        System.out.println(check);
    }

}
