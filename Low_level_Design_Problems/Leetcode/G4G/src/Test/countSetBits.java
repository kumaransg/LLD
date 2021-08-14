package Test;

import java.util.Arrays;
import java.util.Collections;

class countSetBits {
    /* Function to get no of set
    bits in binary representation
    of positive integer n */
    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    // driver program
    public static void main(String args[]) {
        int i = 10;
        System.out.println(countSetBits(i));
        String[] strings = new String[]{"abD","aB","ABC","cDe","CDd"};
        Collections.sort(Arrays.asList(strings), String::compareToIgnoreCase);
        System.out.println(Arrays.toString(strings));
    }
}