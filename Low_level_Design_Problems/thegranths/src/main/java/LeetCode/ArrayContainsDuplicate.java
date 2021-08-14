package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class ArrayContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int num: nums){
            if(s.contains(num)) return true;
            s.add(num);
        }
        return false;
    }
}
