package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class StrangeSorting {
//https://leetcode.com/discuss/interview-question/404304/Goldman-Sachs-or-OA-2020-or-Strange-Sorting-Problem

    public String[] findSort(String[] nums, int[] mapping){
        TreeMap<Integer, ArrayList<String>> tm = new TreeMap<>();
        List<Integer> ls = new ArrayList<>();
        for(int a: mapping)ls.add(a);

        for(String num: nums){
            int formed = 0;
            for(char ch: num.toCharArray()){
                int value = ch-'0';
                int index = ls.indexOf(new Integer(value));
                formed = formed*10+index;
            }
            tm.putIfAbsent(formed, new ArrayList<>());
            tm.get(formed).add(num);
        }
        int index=0;
        for(int a: tm.keySet()){
            List<String> l = tm.get(a);
            for(String toAdd : l){
                nums[index++]=toAdd;
            }
        }
        return nums;
    }

    public static void main(String[] args){

        StrangeSorting ss = new StrangeSorting();
        String [] nums = {"12","02","4", "023", "65", "83", "224", "50"};
        int[] mapping = {2,1,4,8,6,3,0,9,7,5};
        String [] res = ss.findSort(nums,mapping);
        System.out.println(Arrays.toString(res));
        System.out.println(-10/2);
    }
}
