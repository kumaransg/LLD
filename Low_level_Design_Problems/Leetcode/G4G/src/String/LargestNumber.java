package String;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    private static class LargestNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b){
            String order1 = a+b;
            String order2 = b+a;
            System.out.println(a +"***"+b+"***"+order2.compareTo(order1));
            return order2.compareTo(order1);
        }
    }


    public static void main(String args[]){
        int[] arr = new int []{3,30,34,5,9};
        String res = largestNumber(arr);
        System.out.println(res);
    }
    public static String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str[i]= String.valueOf(nums[i]);
        }

        Arrays.sort(str,new LargestNumberComparator());

        if(str[0].equals("0"))
            return "0";

        String res="";
        for(String a: str)
            res+=a;

        return res;

    }
}
