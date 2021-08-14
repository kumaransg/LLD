package LeetCode;

public class Median2SortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if( nums1.length> nums2.length)
            return findMedianSortedArrays(nums2,nums1);
        int x = nums1.length;
        int y = nums2.length;

        int lo =0;
        int hi =x;
        while(lo<=hi){
            int partX = (lo+hi)/2;
            int partY = (x+y+1)/2 - partX;

            int leftMaxX = partX==0?Integer.MIN_VALUE:nums1[partX-1];
            int rightMinX = partX==x?Integer.MAX_VALUE:nums1[partX];

            int leftMaxY = partY==0?Integer.MIN_VALUE:nums2[partY-1];
            int leftMinY = partY==y?Integer.MAX_VALUE:nums2[partY];

            if(leftMaxX<=leftMinY && leftMaxY<=rightMinX){
                if((x+y)%2==0){
                    return (double)(Math.max(leftMaxX,leftMaxY)+Math.min(rightMinX,leftMinY))/2;
                }else{
                    return (double) (Math.max(leftMaxX,leftMaxY));
                }
            }else if(leftMaxX>leftMinY) hi=partX-1;
            else lo=partX+1;
        }
        return 0.0;
    }
    public static void main(String[] args) {
        Median2SortedArray m = new Median2SortedArray();
                m.findMedianSortedArrays(new int[]{1,2,4},new int[]{3,5,9});
    }
}
