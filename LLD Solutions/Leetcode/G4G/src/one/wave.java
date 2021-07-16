package one;

import java.util.Arrays;
import java.util.HashMap;

public class wave {
    public static void main(String args[]) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        int[] arr = {1,2,3,4,5};
        arr = convertToWave(arr,5);
        String a;
        StringBuilder sb = new StringBuilder();
        System.out.print(Arrays.toString(arr));
    }
    public static int[] convertToWave(int arr[], int n){

        // Your code here
        for(int i=1;i<n-1;i++){
            if(i%2!=0) continue;
            System.out.println(i);
            int temp = arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
        return arr;




    }
}
