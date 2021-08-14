package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseFirstK {

    public static void main(String [] args){
        Queue<Integer> q = new LinkedList<>();
        q.add(4);
        q.add(3);
        q.add(1);
        q.add(10);
        q.add(2);
        q.add(6);

        q = reverse(q,2);
        int a = q.size();
        for(int i=0; i< a;i++){
            System.out.print(q.poll()+" ");
        }
    }

    private static Queue<Integer> reverse(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<>();
        while(k>0){
            st.push(q.poll());
            k--;
        }
        Queue<Integer> q2 = new LinkedList<>();
        while(!st.isEmpty())
            q2.add(st.pop());

        while(!q.isEmpty())
            q2.add(q.poll());

        return q2;

    }
}
