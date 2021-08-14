package Array;

public class missingElement {
    int missing(int idx, int[] nums) {
        return nums[idx] - nums[0] - idx;
    }

    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        // If kth missing number is larger than
        // the last element of the array
        if (k > missing(n - 1, nums))
            return nums[n - 1] + k - missing(n - 1, nums);

        int left = 0, right = n - 1, pivot;
        // find left = right index such that
        // missing(left - 1) < k <= missing(left)
        while (left != right) {
            pivot = left + (right - left) / 2;

            if (missing(pivot, nums) < k) left = pivot + 1;
            else right = pivot;
        }

        // kth missing number is larger than nums[idx - 1]
        // and smaller than nums[idx]
        return nums[left - 1] + k - missing(left - 1, nums);
    }
    public static void main(String[] args){
        missingElement me = new missingElement();
        int a = me.missingElement(new int[]{4,7,9,10},12);
        System.out.println(a);
    }
}
