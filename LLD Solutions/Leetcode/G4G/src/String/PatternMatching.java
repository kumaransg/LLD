package String;

import java.util.Arrays;
import java.util.HashSet;

public class PatternMatching {


    private int matching(String pattern, String str){
        pattern="11";
        str="bbbbbbbbbb";

        int count=0;
        for(int i=0;i<str.length();i++){
            if(i+pattern.length()>str.length())
                break;
            if(checkStr(str.substring(i,i+pattern.length()),pattern)) count++;

        }
        return count;
    }
    private boolean checkStr(String str, String pattern){

        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        hs.add('y');

        for(int i=0;i<str.length();i++){
            char strChar = str.charAt(i);
            if(pattern.charAt(i)=='0' && !hs.contains(strChar)){
                return false;
            }
            else if(hs.contains(strChar) && pattern.charAt(i)=='1')
                return false;
        }
        return true;
    }
    public static void main(String []args){
        PatternMatching pm = new PatternMatching();
        System.out.println(pm.matching("",""));
    }
}
