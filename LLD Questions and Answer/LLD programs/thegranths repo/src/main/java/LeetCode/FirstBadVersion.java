package LeetCode;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int lo=1;
        int hi=n;

        while(lo<hi){
            int mid = (lo+hi)/2; //TODO
            if(isBadVersion(mid)) hi=mid;
            else lo=mid+1;
        }
        return lo;
    }

    private boolean isBadVersion(int mid) {
        return true;
        //this function is implemented by leetcode
    }
}
