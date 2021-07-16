package sorting;

import java.util.*;

public class largestNumber {

    private static class LargestNumberComporator implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            String order1 = a+b;
            String order2 = b+a;
            return order2.compareTo(order1);
        }
    }

    public static void main(String args[]) {
        int[] arr = new int[]{3,30,34,5,9};
        String word = largestNumber(arr);
        System.out.println(word);
    }

    public static String largestNumber(int[] nums) {
        String []str = new String[nums.length];
        int i=0;
        for(int a: nums){
            str[i++]=String.valueOf(a);
        }

        Arrays.sort(str,new LargestNumberComporator());

        if (str[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : str) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;

    }
}
