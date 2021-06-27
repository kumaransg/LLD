package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);
        for(int i=1;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0]=map.get(target-nums[i]);
                result[1]=i;
                break;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
