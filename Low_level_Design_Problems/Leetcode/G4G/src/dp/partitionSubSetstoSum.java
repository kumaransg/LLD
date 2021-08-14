package dp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class partitionSubSetstoSum {

    public static void main(String args[]){
        int [] nums = new int[] {1,5,11,5};
        boolean res = canPartition(nums);

    }
    public static boolean canPartition(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // preprocess
        int volumn = 0;
        int s = IntStream.of(nums).sum();
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0) {
            return false;
        }
        volumn /= 2;
        // dp def
        boolean[] dp = new boolean[volumn + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = volumn; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[volumn];
    }
}
