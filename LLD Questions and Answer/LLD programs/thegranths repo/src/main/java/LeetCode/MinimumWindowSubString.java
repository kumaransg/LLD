package LeetCode;

public class MinimumWindowSubString {
    public String minWindow(String s, String t) {

        int[] tArr = new int[256];
        int[] sArr = new int[256];

        for(int i=0;i<t.length();i++){
            tArr[t.charAt(i)]++;
        }

        int start =0; int startIndex=-1;
        int minLen= Integer.MAX_VALUE;
        String result="";
        int count=0;
        for(int i=0;i<s.length();i++){
            sArr[s.charAt(i)]++;
            if(tArr[s.charAt(i)]>0 &&(tArr[s.charAt(i)]>=sArr[s.charAt(i)])){
                count++;
            }

            if(count==t.length()){
                while(sArr[s.charAt(start)]>tArr[s.charAt(start)]
                        ||tArr[s.charAt(start)]==0){

                    if(sArr[s.charAt(start)]>tArr[s.charAt(start)]){
                        sArr[s.charAt(start)]--;
                    }
                    start++;
                }
                if(minLen>i-start+1){
                    startIndex=start;
                    minLen=i-start+1;
                }
            }

        }
        if(startIndex== -1) return "";
        else return s.substring(startIndex,startIndex+minLen);
    }
}
