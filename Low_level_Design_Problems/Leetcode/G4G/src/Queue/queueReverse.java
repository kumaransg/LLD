package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class queueReverse {


    public static void main(String [] args){
        Queue<Integer> q = new LinkedList<>();
        q.add(4);
        q.add(3);
        q.add(1);
        q.add(10);
        q.add(2);
        q.add(6);

        q = reverse(q);
        int a = q.size();
        for(int i=0; i< a;i++){
            System.out.print(q.poll()+" ");
        }
    }

    private static Queue<Integer> reverse(Queue<Integer> q) {
        if(q.isEmpty())
            return q;
        int x = q.poll();
        reverse(q);
        q.add(x);
        return q;
    }
}
