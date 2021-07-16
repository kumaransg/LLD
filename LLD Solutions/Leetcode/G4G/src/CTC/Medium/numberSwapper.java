package CTC.Medium;

import java.util.Arrays;

public class numberSwapper {
    static void swap(int[] nums, int first, int second){
        nums[first]+=nums[second];
        nums[second]=nums[first]-nums[second];
        nums[first]-=nums[second];

    }
    public static void main(String args[]){
        int[] nums = {1,2,3,4,5,6,7,8,9};
        swap(nums,1,2);
        System.out.println(Arrays.toString(nums));
    }
}
