package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums, int targetValue) {
        List<List<Integer>> result = new ArrayList<>() ;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++) {

            if(i>0 && nums[i] == nums[i-1]) continue;
            int target = targetValue-nums[i];
            int low = i+1, high = nums.length-1;

            while(low<high){

                if(nums[low]+nums[high]== target){
                    result.add(Arrays.asList(nums[low],nums[high],nums[i]));
                    while(low<high && nums[low]==nums[low+1]) low++;
                    while(low<high && nums[high]==nums[high-1]) high--;
                    low++;
                    high--;
                }else if(nums[low]+nums[high]<target) low++;
                else high--;
            }

        }

        return result;
    }
}
