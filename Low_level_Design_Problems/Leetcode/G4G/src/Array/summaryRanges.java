package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class summaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ls = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int a = nums[i];
            while(i+1<nums.length && (nums[i+1]-nums[i]==1)){
                i++;
            }
            if(a!=nums[i]){
                ls.add(a+"->"+nums[i]);
            } else {
                ls.add(a+"");
            }
        }
        return ls;
    }
    public static void main(String args[]){
        summaryRanges sr = new summaryRanges();
        int[] arr = {0,2,3,4,6,8,9};
        List<String>ls = sr.summaryRanges(arr);
        System.out.println(ls);
    }
}
