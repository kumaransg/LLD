package Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public  static int check(int[] nums){
        int count = 0;

        //write your code here
        //run unit test to verify the logic
        //execute main to check the time taken for execution
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || nums[i]!=nums[i-1]){
                int sum = 0-nums[i];
                int lo=i+1,hi = nums.length-1;
                while(lo<hi){
                    if(nums[lo]+nums[hi]==sum) {
                        count++;
                        res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        while(lo<hi && nums[lo]==nums[lo+1])lo++;
                        while(lo<hi && nums[hi]==nums[hi-1])hi--;
                        lo++;hi--;
                    }
                    else if(nums[lo]+nums[hi]<sum)lo++;
                    else
                        hi--;
                }
            }
        }
        return count;
        //int count;
//        for(int i=0;i<a.length-2;i++){
//            for(int j=i+1;j<a.length-1;j++){
//                for(int k=j+1;k<a.length;k++){
//                    if(a[i]+a[j]+a[k]==0)
//                        //System.out.println(a[i]+a[j]+a[k]);
//                        count++;
//                }
//            }
//        }

        //return count;
    }
    public static void main(String args[]){
        //int[] ar = {-1,0,1,2,-1,-4};
        int[] ar = {1,0};

        int count = check(ar);
        System.out.println(count);
    }
}
