package LeetCode;

public class BackSpaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length()-1;
        int j= T.length()-1;
        int counter =0;

        while(true){
            counter=0;
            while(i>=0 && (counter>0 || S.charAt(i)=='#')){
                counter += S.charAt(i)=='#'?1:-1;
                i--;
            }
            counter=0;
            while(j>=0 && (counter>0 || T.charAt(j)=='#')){
                counter += T.charAt(j)=='#'?1:-1;
                j--;
            }

            if(i>=0 && j>=0 && S.charAt(i)==T.charAt(j)){
                i--;
                j--;
            }else break;

        }

        return i==-1 && j==-1;
    }
}
