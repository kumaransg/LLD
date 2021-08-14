package LeetCode;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] left = new int[nums.length];
        int[] right= new int[nums.length];
        int[] result = new int[nums.length-k+1];
        left[0] = nums[0];
        right[nums.length-1] = nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            left[i] = (i%k==0)?nums[i]:Math.max(left[i-1],nums[i]);

            right[nums.length-1-i]=((nums.length-1-i) %k==0)?nums[nums.length-1-i]:Math.max(right[nums.length-1-i+1],nums[nums.length-1-i]);
        }

        for(int i=0;i<nums.length-k+1;i++){
            result[i]=Math.max(right[i],left[i+k-1]);
        }
        return result;
    }
}
