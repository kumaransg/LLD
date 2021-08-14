package LeetCode;

public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        if(nums.length==0) return 0;

        int minprod=nums[0];
        int maxprod=nums[0];
        int result=nums[0];

        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<0){
                int tmp = minprod;
                minprod=maxprod;
                maxprod=tmp;
            }

            maxprod= Math.max(nums[i],maxprod*nums[i]);
            minprod= Math.min(nums[i],minprod*nums[i]);
            result=Math.max(result,maxprod);
        }
        return result;
    }
}
