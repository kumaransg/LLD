package LeetCode;

public class HouseRobber {
    public static int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length ==2) return Math.max(nums[0],nums[1]);
        nums[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            nums[i] = Math.max(nums[i-1],nums[i]+nums[i-2]);
        }

        return nums[nums.length-1];
    }


    public static void main(String[] args) {
        rob(new int[]{1,2,5,3,1,4});
    }
}
