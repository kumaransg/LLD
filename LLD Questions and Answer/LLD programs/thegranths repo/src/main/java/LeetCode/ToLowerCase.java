package LeetCode;

public class ToLowerCase {
    public String toLowerCase(String str) {
        char[] result = new char[str.length()];
        int count=0;
        for(char c : str.toCharArray()){
            if(c>='A' && c<='Z'){
                result[count]=(char)(c+32);
            }else {
                result[count] = c;
            }
            count++;
        }
        return new String(result);
    }
}
