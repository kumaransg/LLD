package LeetCode;

public class Sort012inPlace {
    public void sortColors(int[] nums) {

        int lo=0,mid=0, hi = nums.length-1;

        while(mid<=hi){
            if(nums[mid]==0){
                int tmp = nums[lo];
                nums[lo] = nums[mid];
                nums[mid] = tmp;
                lo++; mid++;
            }else if(nums[mid]==1) mid++;
            else{
                int tmp = nums[hi];
                nums[hi]= nums[mid];
                nums[mid]=tmp;
                hi--;
            }

        }

    }
}
