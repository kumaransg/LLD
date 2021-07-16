package Array.GoldMan;

import java.util.HashMap;
import java.util.Map;

public class lengthofCycle {

    public static int lengthOfCycle(int[] arr, int startInd) {
        if (startInd < 0 || startInd >= arr.length) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currentInd = startInd, idx = 0;
        while (currentInd < arr.length) {
            if (map.containsKey(arr[currentInd])) {
                return idx - map.get(arr[currentInd]);
            }
            map.put(arr[currentInd], idx++);
            currentInd = arr[currentInd];
        }
        return -1;
    }

    public static int lengthOfCycleFloydTortoiseAndHare(int[] arr, int startInd) {
        if (startInd < 0 || startInd >= arr.length) {
            return -1;
        }
        int slow = arr[startInd];
        int fast = arr[arr[startInd]];
        // trying to detect a cycle at first
        while (slow != fast) {
            // out of bounds - no cycle
            if (fast >= arr.length) {
                return -1;
            }
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        // yes, there is a cycle for sure, we need to find the starting point
        fast = 0;
        while (fast != slow) {
            fast = arr[fast];
            slow = arr[slow];
        }
        // okay, we have found the starting point, so move away from it again and count the length of the cycle
        int length = 1;
        slow = arr[slow];
        while (fast != slow) {
            length++;
            slow = arr[slow];
        }
        return length;
    }


    public static void main(String[] args){
        int[] r = {1,2,3,1};
        System.out.println(lengthOfCycleFloydTortoiseAndHare(r,0));
    }

}
