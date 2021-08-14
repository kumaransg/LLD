package String;

import java.util.Arrays;

public class urlify {

    public String convert(String name, int len){
        int space =0;
        char[] r = name.toCharArray();
        for(int i =0;i<len;i++){
            if(r[i] ==' ')
                space++;
        }
        System.out.println(space);
        int index = len + 2*space;
        System.out.println(r.length);
        System.out.println(index);
        for(int i=len-1;i>=0;i--){
            if(r[i]==' '){
                r[index-1]='0';
                r[index-2]='2';
                r[index-3]='%';
                index=index-3;
            } else {
                r[index-1]=r[i];
                index--;
            }
        }

        return Arrays.toString(r);
    }

    public static void main(String args[]){
        urlify url = new urlify();
        String name = "Mr John Smith    ";
        name = url.convert(name,13);
        System.out.println(name);
    }
}
