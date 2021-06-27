package LeetCode;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] available = new boolean[n+1];

        for(int i=0;i<n;i++){
            if(nums[i]>0 && nums[i]<=n){
                available[nums[i]] = true;
            }
        }

        for(int i=1;i<n+1;i++){
            if(!available[i]) return i;
        }
        return n+1;
    }

    public static void main(String[] args) {
        FirstMissingPositive f = new FirstMissingPositive();
        f.firstMissingPositive(new int[]{1,2,3});
    }
}
