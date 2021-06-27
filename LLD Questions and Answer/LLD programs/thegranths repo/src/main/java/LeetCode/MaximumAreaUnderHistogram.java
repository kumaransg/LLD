package LeetCode;

import java.util.Stack;

public class MaximumAreaUnderHistogram {
    public int largestRectangleArea(int[] heights) {
        int max =0;
        int area=0;
        int i=0;
        Stack<Integer> stk = new Stack<>();
        for(i=0;i<=heights.length;i++){
            int h = (i==heights.length)?0:heights[i];
            while(!stk.isEmpty() && h<heights[stk.peek()]){
                int currentHeight = heights[stk.pop()];
                int previousIndex = stk.isEmpty()? -1:stk.peek();
                area= currentHeight * (i-previousIndex-1);

                max= Math.max(max,area);
            }
            stk.push(i);
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumAreaUnderHistogram h = new MaximumAreaUnderHistogram();
        h.largestRectangleArea(new int[]{1,2,3});
    }
}
