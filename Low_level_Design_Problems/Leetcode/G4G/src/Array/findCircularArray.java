package Array;

public class findCircularArray {

    public int getLength(int[] arr, int startIndex) {
        if (arr == null || arr.length == 0)
            return -1;
        int count = 0;
        int fast = arr[arr[startIndex]];
        int slow = arr[startIndex];
        while (fast != slow) {
            if (fast >= arr.length)
                return -1;
            count++;
            fast = arr[arr[fast]];
            slow = arr[slow];
        }
        return count;
    }

    public static void main(String[] args){
        //lengthOfCycle([1, 2, 3, 1], 0); // 3
        findCircularArray fca = new findCircularArray();
        int[] arr = {1,2,3,4,5,9,1};
        int result = fca.getLength(arr, 0);
        System.out.println(result);
    }
}
