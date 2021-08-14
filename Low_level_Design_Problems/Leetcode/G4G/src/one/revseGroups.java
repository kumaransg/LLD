package one;

import java.util.ArrayList;
import java.util.Arrays;

public class revseGroups {
    public static ArrayList<Integer> reverseInGroups(ArrayList<Integer> mv, int n, int k) {
        // add your code here

        for (int i = 0; i < n; i += k) {
            int left = i;
            int right = Math.min(n - 1, i + k - 1);
            int temp = 0;

            while (left < right) {
                System.out.println(left + "--" + right);
                temp = mv.get(left);
                System.out.println(temp);
                mv.set(left, mv.get(right));
                System.out.println(mv.get(right));
                mv.set(right, temp);
                System.out.println(mv.get(right));
                System.out.println(mv.get(left) + "---" + mv.get(right));
                right--;
                left++;

                System.out.println("------->");
            }
        }
        return mv;
    }
    public static void main(String args[]){
        ArrayList<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.add(5);
        ls = reverseInGroups(ls,5,3);
        System.out.println(Arrays.toString(ls.toArray()));
    }
}
