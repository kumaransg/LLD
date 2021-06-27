package LeetCode;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {

        if(nums==null || nums.length==0) return 0;
        int n = nums.length;
        HashSet<Integer> s = new HashSet<>();

        for(int i=0;i<n;i++){
            s.add(nums[i]);
        } //O(n)
        int ans=0;
        for(int i=0;i<n;i++){ //O(n)
            int j=0;
            if(!s.contains(nums[i]-1)){
                j = nums[i];
                while(s.contains(j)){
                    j++;
                }

                if(ans< (j-nums[i])){
                    ans=j-nums[i];
                }
            }
        }
        //O(n)+O(n) = 2*O(n) ~ O(n)
        return ans;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        longestConsecutiveSequence.longestConsecutive(new int[]{100,4,200,1,3,2});
    }
}
