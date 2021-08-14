package Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class maxSumArray {

    public static void main(String [] args){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(1);
        q.add(4);
        q.add(5);
        q.add(2);
        q.add(3);
        q.add(6);
        int [] arr = new int [q.size()];
        int l=0;
        while(!q.isEmpty())
        {
            arr[l++]=q.poll();
        }


        StringBuilder sb=new StringBuilder();
        int n = arr.length, k =3;
        for(int i=0;i<=n-k;i++)
        {
            int max=Integer.MIN_VALUE;

            for(int j=i;j<k+i;j++) {
                if(arr[j]>max)
                {
                    max=arr[j];
                }
            }
            sb.append(max+" ");
        }
        System.out.print(sb);
    }
}
