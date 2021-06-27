package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerAfterSelf {

    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        count = new int[nums.length];
        int[] originalIndex = new int[nums.length];

        for(int i=0;i<nums.length;i++) originalIndex[i]=i;

        sort(nums,originalIndex,0,nums.length-1);

        for(int i=0;i<nums.length;i++){
            result.add(count[i]);
        }
        return result;
    }

    private void sort(int[] arr,int[] originalIndex,int l, int r){
        if(l<r){
            int mid=(l+r)/2;
            sort(arr,originalIndex,l,mid);
            sort(arr,originalIndex,mid+1,r);
            merge(arr,originalIndex,l,mid,r);
        }
    }

    private void merge(int[] arr, int[] originalIndex, int left, int mid, int right){
        int lArrSize = mid-left+1;
        int rArrSize = right-mid;
        int[] lArr = new int[lArrSize];
        int[] rArr = new int[rArrSize];

        for(int i = 0; i <lArrSize; i++){
            lArr[i]=originalIndex[left+i];
        }
        for(int j = 0; j < rArrSize; j++){
            rArr[j]=originalIndex[j+mid+1];
        }

        int i=0,j=0,k=left;
        int rightCount=0;
        while(i< lArrSize && j < rArrSize){
            if(arr[lArr[i]]<= arr[rArr[j]]){
                originalIndex[k] = lArr[i];
                count[lArr[i]] += rightCount;
                i++;
            }else{
                originalIndex[k] = rArr[j];
                j++;
                rightCount++;
            }
            k++;
        }

        while(i < lArrSize){
            originalIndex[k] = lArr[i];
            count[lArr[i]] += rightCount;
            i++;
            k++;
        }

        while (j < rArrSize)
        {
            originalIndex[k] = rArr[j];
            j++;
            k++;
        }

    }



    public static void main(String[] args) {
        CountOfSmallerAfterSelf s = new CountOfSmallerAfterSelf();
        s.countSmaller(new int[]{5,2,6,1}).forEach(System.out::print);
    }
}
