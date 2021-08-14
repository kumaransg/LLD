package String;

public class StringCompression {
    public int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public int secondMethod(char[]chars){
        int indexAns=0, index=0;
        while(index<chars.length){
            char currentChar = chars[index];
            int count=0;
            while(index<chars.length && chars[index]== currentChar){
                count++;
                index++;
            }
            chars[indexAns++]=currentChar;
            if(count!=1){
                for(char c: Integer.toString(count).toCharArray()) {
                    System.out.println(c);
                    chars[indexAns++] = c;
                }
            }
        }
        return indexAns;
    }

    public static void main(String args[]){
        StringCompression sc = new StringCompression();
        int a = sc.secondMethod(new char[]{'a','a','b','b','c','c','c'});
        System.out.println(a);
    }
}

