package dp;

import java.util.Arrays;

public class decodeWays {


    public int numDecodings(String s) {
        int [] decodedOrNot = new int[s.length()];
        Arrays.fill(decodedOrNot,-1);
        return numDecodings(s,0,decodedOrNot);
    }
    public int numDecodings(String s, int decodePointer, int[] decodedOrNot){
        if(decodePointer>=s.length())
            return 1;
        if(decodedOrNot[decodePointer]>-1)
            return decodedOrNot[decodePointer];

        int totalDecompistions=0;
        for(int i=1;i<=2;i++){
            if(decodePointer +i <=s.length()){
                String snippet = s.substring(decodePointer,decodePointer+i);

                if(isValid(snippet)){
                    totalDecompistions += numDecodings(s,decodePointer+i,decodedOrNot);
                }
            }
        }
        decodedOrNot[decodePointer]=totalDecompistions;
        return decodedOrNot[decodePointer];

    }

    boolean isValid(String snippet){
        if(snippet.length()==0 || snippet.charAt(0)=='0')
            return false;

        int val = Integer.parseInt(snippet);
        return val>=1 && val<=26;
    }

    public static void main(String args[]){
        decodeWays dw = new decodeWays();
        String number ="226";
        int result = dw.numDecodings(number);
        System.out.println(result);

    }
}
