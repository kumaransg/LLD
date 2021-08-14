package Stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class sortStack {
    public static void main(String args[]){
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        st1.add(9);
        st1.add(8);
        st1.add(1);
        st1.add(2);
        st1.add(6);
        st1.add(4);

        while(!st1.isEmpty()){
            int a = st1.pop();
            while(!tempStack.isEmpty() && tempStack.peek()>a){
                st1.push(tempStack.pop());
            }
            tempStack.push(a);
        }

        while(!tempStack.isEmpty())
            st1.push(tempStack.pop());

        System.out.println(Arrays.toString(st1.toArray()));

    }
}
